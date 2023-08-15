package sample;

import javafx.scene.control.Alert;

public class utilities {

    private static String offlineUUID;

    public static Alert showInformationAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        return alert;
    }

    public static void setOutputUUID(String value) {
        offlineUUID = value;
    }

    public static String getOutputUUID() {
        return offlineUUID;
    }
}
