package ua.edu.ucu.apps.tempseries;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;

    public TempSummaryStatistics() {
        this.avgTemp = 0.0;
        this.devTemp = 0.0;
        this.minTemp = 0.0;
        this.maxTemp = 0.0;
    }
}
