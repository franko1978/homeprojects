package com.sapph.mailchecker;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.FileInputStream;
import java.net.InetAddress;

/**
 * Internet connection tester
 */
public class Pinger {
    final static String ONET_ADDRESS = "213.180.141.140";
    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName(ONET_ADDRESS);
        boolean reachable = address.isReachable(10000);
        while(!reachable) {
            reachable = address.isReachable(10000);
            Thread.sleep(300000);
        }
        FileInputStream fis;

        AudioStream audioStream;
        for(int i = 0; i < 20; i++) {
            fis = new FileInputStream("resources/sound1.wav");
            audioStream = new AudioStream(fis);
            AudioPlayer.player.start(audioStream);
            Thread.sleep(5000);
        }

    }
}
