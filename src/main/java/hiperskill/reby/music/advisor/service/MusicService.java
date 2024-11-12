package hiperskill.reby.music.advisor.service;


import hiperskill.reby.music.advisor.model.Music;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;

import java.io.IOException;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    private SpotifyService spotifyService;

    public List<Music> getNewReleases() throws IOException, SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        return spotifyService.getNewReleases();
    }
}
