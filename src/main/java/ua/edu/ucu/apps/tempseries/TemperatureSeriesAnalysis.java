package ua.edu.ucu.apps.tempseries;
import java.util.Arrays;
import java.util.InputMismatchException;
import lombok.Getter;

@Getter
public class TemperatureSeriesAnalysis {
    private double[] temperatureSeries;
    private static final double NUM = -273.0;

    public TemperatureSeriesAnalysis() {
        this.temperatureSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        if (temperatureSeries == null) {
            throw new IllegalArgumentException();
        }

        for (double temp : temperatureSeries) {
            if (temp < NUM) {
                throw new InputMismatchException();
            }
        }
        this.temperatureSeries = temperatureSeries.clone();
    }

    public double[] getTemperatureSeries() {
        return temperatureSeries.clone();
    }

    private void error() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public double findTempClosest(double tempValue) {
        error();
        double closest = (temperatureSeries[0] - tempValue)
        * (temperatureSeries[0] - tempValue);
        double output = temperatureSeries[0];
        double dist;
        for (double d : temperatureSeries) {
            dist = (d - tempValue) * (d - tempValue);
            if (dist < closest) {
                closest = dist;
                output = d;
            }
            else if ((dist < closest) && (d > 0)) {
                closest = dist;
                output = d;
            }
        }
        return output;
    }

    public double average() {
        error();
        double summary = 0.0;
        for (double part : temperatureSeries) {
            summary += part;
        }
        return summary / temperatureSeries.length;
    }

    public double deviation() {
        error();
        double mean = average();
        double sumSquaredDifferences = 0.0;

        for (double temp : temperatureSeries) {
            sumSquaredDifferences += (temp - mean) * (temp - mean);
        }
        return Math.sqrt(sumSquaredDifferences / temperatureSeries.length);
    }

    public double min() {
        error();
        double minimum = temperatureSeries[0];
        for (double d : temperatureSeries) {
            if (d < minimum) {
                minimum = d;
            }
        }
        return minimum;
    }

    public double max() {
        error();
        double maximum = temperatureSeries[0];
        for (double d : temperatureSeries) {
            if (d > maximum) {
                maximum = d;
            }
        }
        return maximum;
    }

    public double findTempClosestToZero() {
        return findTempClosest(0);
    }

    public double findTempClosestToValue(double tempValue) {
        return findTempClosest(tempValue);
    }

    public double[] findTempsLessThen(double tempValue) {
        int count = 0;
        for (double d : temperatureSeries) {
            if (d < tempValue) {
                count++;
            }
        }

        double[] output = new double[count];
        int index = 0;
        for (double d : temperatureSeries) {
            if (d < tempValue) {
                output[index++] = d;
            }
        }
        return output;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int count = 0;
        for (double d : temperatureSeries) {
            if (d > tempValue) {
                count++;
            }
        }

        double[] output = new double[count];
        int index = 0;
        for (double d : temperatureSeries) {
            if (d > tempValue) {
                output[index++] = d;
            }
        }
        return output;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        int count = 0;
        for (double d : temperatureSeries) {
            if (d > lowerBound && d < upperBound) {
                count++;
            }
        }

        double[] output = new double[count];
        int index = 0;
        for (double d : temperatureSeries) {
            if (d > lowerBound && d < upperBound) {
                output[index++] = d;
            }
        }

        return output;
    }

    public void reset() {
        temperatureSeries = new double[0];
    }

    public double[] sortTemps() {
        Arrays.sort(temperatureSeries);
        return temperatureSeries.clone();
    }

    public TempSummaryStatistics summaryStatistics() {
        error();
        double avgTemp = average();
        double devTemp = deviation();
        double minTemp = min();
        double maxTemp = max();

        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) {
        while (temperatureSeries.length 
        < (temperatureSeries.length + temps.length)) {
            double[] newtemperatureSeries = 
            new double[Math.max(1, 2 * temperatureSeries.length)];
            System.arraycopy(temperatureSeries, 0, 
            newtemperatureSeries, 0, temperatureSeries.length);
            temperatureSeries = newtemperatureSeries;
        }
    
        System.arraycopy(temps, 0, 
        temperatureSeries, temperatureSeries.length - temps.length, 
        temps.length);
        return temperatureSeries.length;
    }
}
