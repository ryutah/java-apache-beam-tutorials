package client;

import java.io.Serializable;

public interface Client extends Serializable {
    void publish(String message);
}
