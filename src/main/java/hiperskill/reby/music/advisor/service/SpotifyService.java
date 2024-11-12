package hiperskill.reby.music.advisor.service;

import hiperskill.reby.music.advisor.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.AlbumSimplified;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.requests.data.browse.GetListOfNewReleasesRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpotifyService {

    @Autowired
    private SpotifyApi spotifyApi;

    public List<Music> getNewReleases() throws IOException, SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        if (spotifyApi.getAccessToken() == null) {
            throw new IllegalStateException("Access token is not set. Please authenticate first.");
        }

        GetListOfNewReleasesRequest getListOfNewReleasesRequest = spotifyApi.getListOfNewReleases().build();
        Paging<AlbumSimplified> albumSimplifiedPaging = getListOfNewReleasesRequest.execute();

        List<Music> newReleases = new ArrayList<>();
        for (AlbumSimplified album : albumSimplifiedPaging.getItems()) {
            Music music = new Music();
            music.setTitle(album.getName());
            music.setArtist(album.getArtists()[0].getName());
            music.setAlbum(album.getName());
            newReleases.add(music);
        }
        return newReleases;
    }
}

