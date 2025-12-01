package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

public class PlaylistRecommenderTest {

    // ==================== classifyEnergy Tests ====================
    
    @Test
    public void testClassifyEnergyHigh() {
        List<Integer> bpms = Arrays.asList(150, 160, 140);
        assertEquals("HIGH", PlaylistRecommender.classifyEnergy(bpms));
    }
    
    @Test
    public void testClassifyEnergyMedium() {
        List<Integer> bpms = Arrays.asList(100, 120, 110);
        assertEquals("MEDIUM", PlaylistRecommender.classifyEnergy(bpms));
    }
    
    @Test
    public void testClassifyEnergyLow() {
        List<Integer> bpms = Arrays.asList(80, 90, 70);
        assertEquals("LOW", PlaylistRecommender.classifyEnergy(bpms));
    }
    
    // ==================== isValidTrackTitle Tests ====================
    
    @Test
    public void testIsValidTrackTitleValid() {
        assertTrue(PlaylistRecommender.isValidTrackTitle("Bohemian Rhapsody"));
    }
    
    @Test
    public void testIsValidTrackTitleNull() {
        assertFalse(PlaylistRecommender.isValidTrackTitle(null));
    }
    
    @Test
    public void testIsValidTrackTitleWithNumbers() {
        assertFalse(PlaylistRecommender.isValidTrackTitle("Track 2023"));
    }
    
    // ==================== normalizeVolume Tests ====================
    
    @Test
    public void testNormalizeVolumeTooHigh() {
        assertEquals(100, PlaylistRecommender.normalizeVolume(120));
    }
    
    @Test
    public void testNormalizeVolumeTooLow() {
        assertEquals(0, PlaylistRecommender.normalizeVolume(-10));
    }
    
    @Test
    public void testNormalizeVolumeInRange() {
        assertEquals(50, PlaylistRecommender.normalizeVolume(50));
    }
}
