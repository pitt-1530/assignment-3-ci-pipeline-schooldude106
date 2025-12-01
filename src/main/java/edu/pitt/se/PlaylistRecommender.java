package edu.pitt.se;

import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if (bpms == null || bpms.isEmpty()) {
            throw new IllegalArgumentException("BPM list cannot be null or empty");
        }
        
        double sum = 0;
        for (int bpm : bpms) {
            sum += bpm;
        }
        double avgBpm = sum / bpms.size();
        
        if (avgBpm >= 140) {
            return "HIGH";
        } else if (avgBpm >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if (title == null) {
            return false;
        }
        
        int length = title.length();
        if (length < 1 || length > 30) {
            return false;
        }
        
        for (int i = 0; i < length; i++) {
            char c = title.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        
        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if (volumeDb < 0) {
            return 0;
        } else if (volumeDb > 100) {
            return 100;
        } else {
            return volumeDb;
        }
    }
}
