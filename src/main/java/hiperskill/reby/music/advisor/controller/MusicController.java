package hiperskill.reby.music.advisor.controller;


import hiperskill.reby.music.advisor.model.Music;
import hiperskill.reby.music.advisor.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping("/new-releases")
    public List<Music> getNewReleases() throws IOException, se.michaelthelin.spotify.exceptions.SpotifyWebApiException, org.apache.hc.core5.http.ParseException {
        return musicService.getNewReleases();
    }
}
