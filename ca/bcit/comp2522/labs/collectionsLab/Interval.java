package ca.bcit.comp2522.labs.collectionsLab;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Interval {

    private Duration duration;

    public Interval(long nanos) {
        duration = Duration.of(nanos, ChronoUnit.NANOS);
    }

    @Override
    public String toString() {
        String resultString = "";
        resultString = duration.toSecondsPart() + "." + duration.toNanosPart()/1000 + "s";
        if (duration.toMinutesPart() > 0) {
            resultString = duration.toMinutesPart() + " m " + resultString;
        }
        return resultString;
    }
}

