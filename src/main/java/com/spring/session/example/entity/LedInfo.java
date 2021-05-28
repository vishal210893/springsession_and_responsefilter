package com.spring.session.example.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonFilter("inclusion")
public class LedInfo {

    private LabelLedColor color;

    private BlickingDurationTime duration;

    private String pattern;

    private String productInfo;


    @Getter
    public enum LabelLedColor {
        RED(true, false, false),
        GREEN(false, true, false),
        YELLOW(true, true, false),
        BLUE(false, false, true),
        MAGENTA(true, false, true),
        CYAN(false, true, true),
        WHITE(true, true, true);

        private List<Boolean> value;

        LabelLedColor(boolean red, boolean green, boolean blue) {
            this.value = new ArrayList<>();
            value.add(red);
            value.add(green);
            value.add(blue);
        }
    }

    @Getter
    public enum BlickingDurationTime {
        @JsonProperty("0") OFF(0),
        @JsonProperty("10s") SECOND_10(1),
        @JsonProperty("20s") SECOND_20(2),
        @JsonProperty("30s") SECOND_30(3),
        @JsonProperty("40s") SECOND_40(4),
        @JsonProperty("50s") SECOND_50(5),
        @JsonProperty("1m") SECOND_60(6),
        @JsonProperty("70s") SECOND_70(7),
        @JsonProperty("80s") SECOND_80(8),
        @JsonProperty("90s") SECOND_90(9),
        @JsonProperty("100s") SECOND_100(10),
        @JsonProperty("110s") SECOND_110(11),
        @JsonProperty("2m") SECOND_120(12),
        @JsonProperty("130s") SECOND_130(13),
        @JsonProperty("140s") SECOND_140(14),
        @JsonProperty("150s") SECOND_150(15),
        @JsonProperty("5m") MINUTE_5(16),
        @JsonProperty("10m") MINUTE_10(17),
        @JsonProperty("15m") MINUTE_15(18),
        @JsonProperty("20m") MINUTE_20(19),
        @JsonProperty("25m") MINUTE_25(20),
        @JsonProperty("30m") MINUTE_30(21),
        @JsonProperty("35m") MINUTE_35(22),
        @JsonProperty("40m") MINUTE_40(23),
        @JsonProperty("45m") MINUTE_45(24),
        @JsonProperty("50m") MINUTE_50(25),
        @JsonProperty("55m") MINUTE_55(26),
        @JsonProperty("60m") MINUTE_60(27),
        @JsonProperty("65m") MINUTE_65(28),
        @JsonProperty("70m") MINUTE_70(29),
        @JsonProperty("75m") MINUTE_75(30);

        private int value;

        BlickingDurationTime(int v) {
            this.value = v;
        }
    }

}