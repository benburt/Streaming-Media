import java.io.BufferedInputStream;
import java.net.URL;

import javazoom.jl.player.Player;


public class PlayStream {
    private String filename = "http://localhost:8000";
    private Player player; 

    public void close() { if (player != null) player.close(); }
    // play the MP3 file to the sound card
    public void play() {
        try {
        System.out.println("Buffering...");
        BufferedInputStream bis = new BufferedInputStream(new URL(filename).openConnection().getInputStream());
        player = new Player(bis);
        }
        catch (Exception e) {
            System.out.println("Problem playing: " + filename);
            System.out.println("Error: " + e.getMessage());
        }
        // run in new thread to play in background
        new Thread() {
            public void run() {
            	if (player == null) return;
                try { player.play(); }
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }

}

