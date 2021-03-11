import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PrisonerProfile extends Application {

    Stage ProfileStage = new Stage();
    private Label lblPrsProfile, lblPrisonerID, lblFName, lblMidName, lblLName, lblEntranceDate, lblReleaseDate;
    private Label lblSecuLevel, lblCellShare, lblCellNo;
    private TextField txfPrsID, txfFName, txfMidName, txfLName, txfEntDate, txfRelDate, txfSecLev, txfCellSh, txfCellNo;
    private Button btnGoBack;
    private Rectangle ImgRect;
    private ImageView ImgView;


    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Pane ProfilePane = new Pane();

        lblPrsProfile = new Label("Prisoner Profile");
             lblPrsProfile.setLayoutX(40);
             lblPrsProfile.setLayoutY(20);
             lblPrsProfile.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,20));
        lblPrisonerID = new Label("Prisoner ID");
             lblPrisonerID.setLayoutX(50);
             lblPrisonerID.setLayoutY(60);
             lblPrisonerID.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblFName = new Label("FirstName");
             lblFName.setLayoutX(50);
             lblFName.setLayoutY(100);
             lblFName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblMidName = new Label("MiddleName");
             lblMidName.setLayoutX(50);
             lblMidName.setLayoutY(140);
             lblMidName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblLName = new Label("LastName");
             lblLName.setLayoutX(50);
             lblLName.setLayoutY(180);
             lblLName.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblEntranceDate = new Label("Entrance Date");
             lblEntranceDate.setLayoutX(50);
             lblEntranceDate.setLayoutY(220);
             lblEntranceDate.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblReleaseDate = new Label("Release Date");
             lblReleaseDate.setLayoutX(50);
             lblReleaseDate.setLayoutY(260);
             lblReleaseDate.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblSecuLevel = new Label("Security Level");
             lblSecuLevel.setLayoutX(50);
             lblSecuLevel.setLayoutY(300);
             lblSecuLevel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblCellShare = new Label("Cell Sharing");
             lblCellShare.setLayoutX(50);
             lblCellShare.setLayoutY(340);
             lblCellShare.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        lblCellNo = new Label("Cell Number");
             lblCellNo.setLayoutX(50);
             lblCellNo.setLayoutY(380);
             lblCellNo.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,16));
        txfPrsID = new TextField();
             txfPrsID.setPrefColumnCount(15);
             txfPrsID.setLayoutX(180);
             txfPrsID.setLayoutY(60);
             txfPrsID.setEditable(false);
        txfFName = new TextField();
             txfFName.setPrefColumnCount(15);
             txfFName.setLayoutX(180);
             txfFName.setLayoutY(100);
             txfFName.setEditable(false);
        txfMidName = new TextField();
             txfMidName.setPrefColumnCount(15);
             txfMidName.setLayoutX(180);
             txfMidName.setLayoutY(140);
             txfMidName.setEditable(false);
        txfLName = new TextField();
             txfLName.setPrefColumnCount(15);
             txfLName.setLayoutX(180);
             txfLName.setLayoutY(180);
             txfLName.setEditable(false);
        txfEntDate = new TextField();
             txfEntDate.setPrefColumnCount(15);
             txfEntDate.setLayoutX(180);
             txfEntDate.setLayoutY(220);
             txfEntDate.setEditable(false);
         txfRelDate = new TextField();
             txfRelDate.setPrefColumnCount(15);
             txfRelDate.setLayoutX(180);
             txfRelDate.setLayoutY(260);
             txfRelDate.setEditable(false);
         txfSecLev = new TextField();
             txfSecLev.setPrefColumnCount(15);
             txfSecLev.setLayoutX(180);
             txfSecLev.setLayoutY(300);
             txfSecLev.setEditable(false);
         txfCellSh = new TextField();
             txfCellSh.setPrefColumnCount(15);
             txfCellSh.setLayoutX(180);
             txfCellSh.setLayoutY(340);
             txfCellSh.setEditable(false);
         txfCellNo = new TextField();
             txfCellNo.setPrefColumnCount(15);
             txfCellNo.setLayoutX(180);
             txfCellNo.setLayoutY(380);
             txfCellNo.setEditable(false);
         btnGoBack = new Button("Go Back");
             btnGoBack.setLayoutX(700);
             btnGoBack.setLayoutY(550);
             btnGoBack.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,14));
             btnGoBack.setOnAction(event -> {
                 Prisoner Pris = new Prisoner();
                    Pris.start(Pris.PrisonerStage);
                    ProfileStage.hide();
             });
         ImgRect = new Rectangle(500,50,100,100);
             ImgRect.setStroke(Color.BLACK);
             ImgRect.setFill(Color.WHITE);
         Image Img = new Image("imagesPP.jpeg");
         ImgView = new ImageView(Img);
             ImgView.setFitWidth(99);
             ImgView.setFitHeight(99);
             ImgView.setLayoutX(500);
             ImgView.setLayoutY(50);;

        ProfilePane.getChildren().addAll(lblPrsProfile,lblPrisonerID,lblFName,lblMidName,lblLName,lblEntranceDate,lblReleaseDate,
                lblSecuLevel,lblCellShare,lblCellNo,txfPrsID,txfFName,txfMidName,txfLName,txfEntDate,txfRelDate,txfSecLev,
                txfCellSh,txfCellNo,ImgRect,ImgView,btnGoBack);

        Scene ProfileScene = new Scene(ProfilePane,800,600);

        ProfileStage.setTitle("Prisoner Profile");
        ProfileStage.setResizable(false);
        ProfileStage.setScene(ProfileScene);
        ProfileStage.show();
    }
}
