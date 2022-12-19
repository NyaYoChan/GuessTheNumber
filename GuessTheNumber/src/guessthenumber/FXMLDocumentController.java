package guessthenumber;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Button guessButton;
    @FXML
    private Button newGameButton;
    
    @FXML
    private TextField guessTextField;
    
    @FXML
    private TextArea screenTextArea;
    
    private int targetNumber = (int)(Math.random()*100 % 20) + 1;
    private int playTimes = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void buttonOnClicked(ActionEvent event){
        System.out.println(targetNumber);
        try{
            Button clickedButton = (Button)event.getSource();
            switch(clickedButton.getId()){
                case "guessButton":
                    String input = guessTextField.getText();
                    playTimes++;
                    if(Integer.parseInt(input) == targetNumber){
                        screenTextArea.appendText("猜對了(次數：" + String.valueOf(playTimes) + ")\n");
                    }else if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= 20){
                        if(Integer.parseInt(input) > targetNumber){
                            screenTextArea.appendText("比" + input + "小" + "(次數：" + String.valueOf(playTimes) + ")\n");
                        }else{
                            screenTextArea.appendText("比" + input + "大" + "(次數：" + String.valueOf(playTimes) + ")\n");
                        }
                    }else{
                        playTimes--;
                        screenTextArea.appendText("請輸入1-20的整數\n");
                    }
                    break;
                case "newGameButton":
                    targetNumber = (int)(Math.random()*100 % 20) + 1;
                    playTimes = 0;
                    screenTextArea.clear();
                    break;
            }
        }catch(NumberFormatException e){
            playTimes--;
            screenTextArea.appendText("請輸入1-20的整數\n");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
}
