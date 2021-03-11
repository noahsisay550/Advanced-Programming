import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Administration extends Application {

    Stage AdminStage = new Stage();

    private Button btnShowPLog,btnShowStaff,btnShowPrisInfo,btnReports,btnCreateAdminAcc,btnLogin,btnForgotPass,btnGoBack;
    private Label lblUserName,lblPassword;
    private PasswordField passField;
    private TextField UNameTxf;

    public static void main(String[]args){
        launch(args);
    }

    public void start(Stage primaryStage){
        Pane AdminPane = new Pane();

        Image AdminImage = new Image("imagesA.jpeg");
        ImageView AdminIV = new ImageView(AdminImage);

        AdminIV.fitWidthProperty().bind(AdminPane.widthProperty().subtract(200));
        AdminIV.fitHeightProperty().bind(AdminPane.heightProperty());

        lblUserName = new Label("UserName");
        lblUserName.setLayoutX(620);
        lblUserName.setLayoutY(120);
        lblUserName.setTextFill(Color.BLACK);
        lblUserName.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        lblPassword = new Label("Password");
        lblPassword.setLayoutX(620);
        lblPassword.setLayoutY(190);
        lblPassword.setTextFill(Color.BLACK);
        lblPassword.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 18));
        UNameTxf = new TextField();
        UNameTxf.setPrefColumnCount(13);
        UNameTxf.setLayoutX(620);
        UNameTxf.setLayoutY(155);
        UNameTxf.setOnAction(event -> {
            UNameTxf.getText();
            passField.requestFocus();
        });
        passField = new PasswordField();
        passField.setPrefColumnCount(13);
        passField.setLayoutX(620);
        passField.setLayoutY(225);
        passField.setOnAction(event -> {
            passField.getText();
            btnLogin.requestFocus();
        });
        btnLogin = new Button("Login");
        btnLogin.setPrefSize(100,15);
        btnLogin.setLayoutX(620);
        btnLogin.setLayoutY(265);
        btnLogin.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 12));
        btnLogin.setOnAction(event -> {

        });
        btnLogin.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)) {

            }
        });
        btnForgotPass = new Button("Forgot Password");
        btnForgotPass.setPrefSize(100, 15);
        btnForgotPass.setLayoutX(620);
        btnForgotPass.setLayoutY(300);
        btnForgotPass.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 10));
        btnGoBack = new Button("Go Back");
        btnGoBack.setPrefSize(100,15);
        btnGoBack.setLayoutX(620);
        btnGoBack.setLayoutY(550);
        btnGoBack.setFont(Font.font("Courier", FontWeight.BOLD, FontPosture.REGULAR, 12));
        btnGoBack.setOnAction(event -> {
            PrisonWelcome PW = new PrisonWelcome();
            PW.start(PW.HomeStage);
            AdminStage.hide();
        });


        btnShowPLog = new Button("Prisoner Log");
            btnShowPLog.setLayoutX(100);
            btnShowPLog.setLayoutY(200);
        btnShowStaff = new Button("Staff Log");
            btnShowStaff.setLayoutX(100);
            btnShowStaff.setLayoutY(300);
        btnCreateAdminAcc = new Button("Create Admin");
            btnCreateAdminAcc.setLayoutX(300);
            btnCreateAdminAcc.setLayoutY(200);
        btnShowPrisInfo = new Button("Show Information");
            btnShowPrisInfo.setLayoutX(100);
            btnShowPrisInfo.setLayoutY(400);
        btnReports = new Button("Reports");
            btnReports.setLayoutX(300);
            btnReports.setLayoutY(300);

        AdminPane.getChildren().addAll(AdminIV,lblUserName,lblPassword,UNameTxf,passField,btnLogin,btnForgotPass,btnGoBack);
        Scene AdminScene = new Scene(AdminPane,800,600);
        AdminStage.setScene(AdminScene);
        AdminStage.setTitle("Prison Administration");
        AdminStage.show();
    }
}
