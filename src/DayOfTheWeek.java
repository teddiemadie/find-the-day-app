import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;
// import javafx.scene.text.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DayOfTheWeek extends Application {
    public static void main(String[] args){
        launch(args);
    }
    public void start(Stage myStage) {
        myStage.setTitle("Find the day of the week App");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.TOP_LEFT);
        Scene myScene = new Scene(rootNode,400,650);
        myStage.setScene(myScene);
        Image img = new Image("https://www.takushoku-u.ac.jp/summary/images/211_symbol_mark_img_1.gif");
        ImageView logo = new ImageView(img);
        Image mon = new Image("https://3.bp.blogspot.com/-Pa0WFqAs2oo/VJF_8k5PIbI/AAAAAAAAp8M/NsMSODwIM14/s800/week2_monday.png");
        Image tue = new Image("https://2.bp.blogspot.com/-pj8izjLAQ1E/VJF_9FpLEmI/AAAAAAAAp8c/4wnVetTYp_M/s800/week3_tuesday.png");
        Image wed = new Image("https://1.bp.blogspot.com/-xg5gQiAXa3g/VJF_9gJXLgI/AAAAAAAAp8k/Ur3jEkTL2qU/s800/week4_wednesday.png");
        Image thu = new Image("https://2.bp.blogspot.com/-01lNuBxorbM/VJF_-ZOOBRI/AAAAAAAAp8s/r81rLy78ZsI/s800/week5_thursday.png");
        Image fri = new Image("https://4.bp.blogspot.com/-snOdNUuwF60/VJF_-x5RvPI/AAAAAAAAp8w/8DzPKKcrCko/s800/week6_friday.png");
        Image sat = new Image("https://1.bp.blogspot.com/-kAwMkjODz2k/VJF__3R-JHI/AAAAAAAAp84/3Om1LAYc0Wc/s800/week7_saturday.png");
        Image sun = new Image("https://1.bp.blogspot.com/-DQ4A2mpLYiA/VJF_8EqPbCI/AAAAAAAAp8I/H4PlYhK3vTk/s800/week1_sunday.png");
        
        ImageView ouputImg = new ImageView(); 
        TextField fd = new TextField();
        fd.setPrefWidth(250);
        fd.setText("YEAR/MONTH/DAY");               

        //the function which finds the day of the week
        Label response = new Label();
        Button btnSend = new Button("Search");
        btnSend.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae){
                int y = 0;
                int m = 0;
                int d = 0;
                String input = fd.getText();
                String[] split = input.split("/");
                y = Integer.parseInt(split[0]);
                m = Integer.parseInt(split[1]);        
                d = Integer.parseInt(split[2]);

                MyBirthday mybd = new MyBirthday(y,m,d);
                if(mybd.checkValidValue() == false){
                    response.setText("INVALID VALUE!!!TRY AGAIN");
                }else{
                    response.setText(fd.getText() + " is " + mybd.getDayOfWeek());
                    switch (mybd.getDayOfWeek()) {
                        case "MON":
                            ouputImg.setImage(mon);
                            break;
                        case "TUE":
                            ouputImg.setImage(tue);
                            break;
                        case "WED":
                            ouputImg.setImage(wed);
                            break;
                        case "THU":
                            ouputImg.setImage(thu);
                            break;
                        case "FRI":
                            ouputImg.setImage(fri);
                            break;
                        case "SAT":
                            ouputImg.setImage(sat);
                            break;
                        case "SUN":
                            ouputImg.setImage(sun);
                            break;
                    }
                }

            }
        });

        //the feature that changes the year to Japanese calendar
        Label response2 = new Label();
        Button btn2 = new Button("To Wareki");
        btn2.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent ae){
                int y = 0;
                int m = 0;
                int d = 0;
                String input = fd.getText();
                String[] split = input.split("/");
                y = Integer.parseInt(split[0]);
                m = Integer.parseInt(split[1]);        
                d = Integer.parseInt(split[2]);

                MyBirthday mybd = new MyBirthday(y,m,d);
                if(mybd.checkValidValue() == false){
                    response2.setText("INVALID VALUE!!!TRY AGAIN");
                }else{
                    response2.setText(y + " is " + mybd.toWareki());
                }
            }
        });
        rootNode.getChildren().addAll(logo,fd,btnSend,response,ouputImg,btn2,response2);
        myStage.show();
    }
}