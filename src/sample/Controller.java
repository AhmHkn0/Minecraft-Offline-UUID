package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Controller {

    @FXML
    private Text outputText;

    @FXML
    private Text copied;

    @FXML
    private TextField playerNameFiled;

    @FXML
    void getOfflineUUID(MouseEvent event) {
        String playerName = playerNameFiled.getText();
        if (playerName.isEmpty())
            outputText.setText("Please text player name.");
        else {
            String output = getUUID(playerNameFiled.getText());
            outputText.setText(output);
            utilities.setOutputUUID(output);
            copied.setText("");
        }
    }

    @FXML
    void copy(MouseEvent event) {
        if (utilities.getOutputUUID() == null || utilities.getOutputUUID().isEmpty())
            utilities.showInformationAlert("Warning!", "Can't find player name.", "Please text player name.").showAndWait();
        else
            copyUUID();
    }

    @FXML
    void textChange(KeyEvent event) {
        utilities.setOutputUUID("");
    }

    private void copyUUID() {
        ClipboardContent content = new ClipboardContent();
        content.putString(outputText.getText());
        Clipboard.getSystemClipboard().setContent(content);

        copied.setText("Copied");
        copied.setFill(Color.GREEN);
        copied.setFont(Font.font(copied.getFont().getFamily(), FontWeight.BOLD, copied.getFont().getSize()));
    }

    private String getUUID(String playerName) {
        return UUID.nameUUIDFromBytes(("OfflinePlayer:" + playerName).getBytes(StandardCharsets.UTF_8)).toString();
    }
}
