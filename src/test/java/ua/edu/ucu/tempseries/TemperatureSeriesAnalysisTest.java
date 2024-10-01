package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {
    private TemperatureSeriesAnalysis seriesAnalysisEmpty;
    private TemperatureSeriesAnalysis seriesAnalysisOne;
    private TemperatureSeriesAnalysis seriesAnalysisSev;

    @Before
    public void setUp() {
        double[] temperatureSeriesEmpty = new double[0];
        seriesAnalysisEmpty = new TemperatureSeriesAnalysis(temperatureSeriesEmpty);

        // Initialize the one-element series
        double[] temperatureSeriesOne = {-1.0};
        seriesAnalysisOne = new TemperatureSeriesAnalysis(temperatureSeriesOne);
        System.out.println(seriesAnalysisOne.getTemperatureSeries());

        // Initialize the multi-element series
        double[] temperatureSeriesSev = {3.0, -5.0, 1.0, 5.0};
        seriesAnalysisSev = new TemperatureSeriesAnalysis(temperatureSeriesSev);
        
    }

    @Test
    public void test() {
        double expResult = -1.0;

        double actualResult = seriesAnalysisOne.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test
   public void testAverageWithOneElementArray() {
       // setup input data and expected result
       double expResult = -1.0;

       // call tested method
       double actualResult = seriesAnalysisOne.average();

       // compare expected result with actual result
       assertEquals(expResult, actualResult, 0.00001);
   }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        seriesAnalysisEmpty.average();
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;
        double actualResult = seriesAnalysisSev.average();
        assertEquals(expResult, actualResult, 0.00001);
    }

   @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptySeries() {
        seriesAnalysisEmpty.deviation();
    }

    @Test
    public void testDeviationWithOneElementArray() {
       double expResult = 0.0;
       double actualResult = seriesAnalysisOne.deviation();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testDeviation() {
       double expResult = 3.74;
       double actualResult = seriesAnalysisSev.deviation();
       assertEquals(expResult, actualResult, 0.01);
   }

   @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptySeries() {
        seriesAnalysisEmpty.min();
    }

    @Test
    public void testMinWithOneElementArray() {
       double expResult = -1.0;
       double actualResult = seriesAnalysisOne.min();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testMin() {
       double expResult = -5.0;
       double actualResult = seriesAnalysisSev.min();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptySeries() {
        seriesAnalysisEmpty.max();
    }

    @Test
    public void testMaxWithOneElementArray() {
       double expResult = -1.0;
       double actualResult = seriesAnalysisOne.max();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testMax() {
       double expResult = 5.0;
       double actualResult = seriesAnalysisSev.max();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
    public void testTempClosestToZeroWithEmptySeries() {
        seriesAnalysisEmpty.findTempClosestToZero();
    }

    @Test
    public void testTempClosestToZeroWithOneElementArray() {
       double expResult = -1.0;
       double actualResult = seriesAnalysisOne.findTempClosestToZero();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testTempClosestToZero() {
       double expResult = 1.0;
       double actualResult = seriesAnalysisSev.findTempClosestToZero();
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test(expected = IllegalArgumentException.class)
    public void testTempClosestToValueWithEmptySeries() {
        seriesAnalysisEmpty.findTempClosestToValue(2);
    }

    @Test
    public void testTempClosestToValueWithOneElementArray() {
       double expResult = -1.0;
       double actualResult = seriesAnalysisOne.findTempClosestToValue(2);
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testTempClosestToValue() {
       double expResult = 1;
       double actualResult = seriesAnalysisSev.findTempClosestToValue(1.5);
       assertEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testTempsLessThanWithEmptySeries() {
        double[] expResult = new double[0];
        double[] actualResult = seriesAnalysisEmpty.findTempsLessThen(2);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsLessThanWithOneElementArray() {
       double[] expResult = {-1.0};
       double[] actualResult = seriesAnalysisOne.findTempsLessThen(2);
       assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testTempsLessThan() {
    double[] expResult = {-5.0, 1.0};
    double[] actualResult = seriesAnalysisSev.findTempsLessThen(2);
    assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testTempsGreaterThanWithEmptySeries() {
        double[] expResult = {};
        double[] actualResult = seriesAnalysisEmpty.findTempsGreaterThen(2);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsGreaterThanWithOneElementArray() {
       double[] expResult = {};
       double[] actualResult = seriesAnalysisOne.findTempsGreaterThen(2);
       assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testTempsGreaterThan() {
    double[] expResult = {3.0, 5.0};
    double[] actualResult = seriesAnalysisSev.findTempsGreaterThen(2.0);
    assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
    public void testTempsInRangeWithEmptySeries() {
        double[] expResult = new double[0];
        double[] actualResult = seriesAnalysisEmpty.findTempsInRange(2.4, 6.0);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testTempsInRangeWithOneElementArray() {
       double[] expResult = {-1.0};
       double[] actualResult = seriesAnalysisOne.findTempsInRange(-2.4, 6.0);
       assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testTempsInRangeThan() {
    double[] expResult = {3.0, 5.0};
    double[] actualResult = seriesAnalysisSev.findTempsInRange(2.4, 6.0);
    assertArrayEquals(expResult, actualResult, 0.00001);
   }

   @Test
   public void testResetWithEmptySeries() {
        seriesAnalysisEmpty.reset();
        double[] expOutput = {};
        assertArrayEquals(seriesAnalysisEmpty.getTemperatureSeries(), expOutput, 0.00001);
    }

   @Test
    public void testResetWithOneElementArray() {
        seriesAnalysisOne.reset();
        double[] expOutput = {};
        assertArrayEquals(seriesAnalysisOne.getTemperatureSeries(), expOutput, 0.00001);
    }

    @Test
    public void testReset() {
        seriesAnalysisOne.reset();
        double[] expOutput = {};
        assertArrayEquals(seriesAnalysisOne.getTemperatureSeries(), expOutput, 0.00001);
    }

    @Test
   public void testSortWithEmptySeries() {
        double[] actualResult = seriesAnalysisEmpty.sortTemps();
        double[] expOutput = {};
        assertArrayEquals(actualResult, expOutput, 0.00001);
    
    }

   @Test
    public void testSortWithOneElementArray() {
        double[] actualResult = seriesAnalysisEmpty.sortTemps();
        double[] expOutput = {};
        assertArrayEquals(actualResult, expOutput, 0.00001);
    }

    @Test
    public void testSort() {
        double[] actualResult = seriesAnalysisEmpty.sortTemps();
        double[] expOutput = {};
        assertArrayEquals(actualResult, expOutput, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempSummaryStatisticsWithEmptySeries() {
        seriesAnalysisEmpty.summaryStatistics();
    }

   @Test
    public void testTempSummaryStatisticsWithOneElementArray() {
        TempSummaryStatistics stats = seriesAnalysisOne.summaryStatistics();
        assertEquals(-1.0, stats.getAvgTemp(), 0.001);
        assertEquals(-1.0, stats.getMinTemp(), 0.001);
        assertEquals(-1.0, stats.getMaxTemp(), 0.001);
        assertEquals(0.0, stats.getDevTemp(), 0.001);
    }

    @Test
    public void testTempSummaryStatistics() {
        TempSummaryStatistics stats = seriesAnalysisSev.summaryStatistics();
        assertEquals(1.0, stats.getAvgTemp(), 0.001);
        assertEquals(-5.0, stats.getMinTemp(), 0.001);
        assertEquals(5.0, stats.getMaxTemp(), 0.001);
        assertEquals(3.74, stats.getDevTemp(), 0.01);
    }
    
}