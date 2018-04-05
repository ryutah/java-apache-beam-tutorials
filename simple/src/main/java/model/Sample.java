package model;

import java.util.Arrays;
import java.util.Optional;
import org.apache.beam.sdk.coders.AvroCoder;
import org.apache.beam.sdk.coders.DefaultCoder;

@DefaultCoder(AvroCoder.class)
public class Sample {
    public static enum Label {
        NEW("new"),
        OLD("old"),
        OTHER("");

        public final String LABEL;

        Label(String label) {
            this.LABEL = label;
        }

        public static Label labelOf(String label) {
            return Arrays.stream(values())
                    .filter(l -> l.LABEL.equals(label))
                    .findFirst()
                    .orElse(OTHER);
        }
    }

    private String url;
    private Label label;

    public Sample() {}

    public Sample(String url, String label) {
        this.url = Optional.ofNullable(url).orElse("");
        this.label = Label.labelOf(label);
    }

    public String getUrl() {
        return url;
    }

    public Label getLabel() {
        return label;
    }
}
