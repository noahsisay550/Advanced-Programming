import javafx.application.Application;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import java.io.File;
import java.util.Optional;

public class AddPrisoner extends Application {

    Stage AddPrisoner = new Stage();
    private Label lblPrsProfile, lblFName, lblMidName, lblLName, lblEntranceDate, lblReleaseDate;
    private Label lblSecuLevel, lblCellShare, lblCellNo;
    private TextField txfFName, txfMidName, txfLName, txfSecLev, txfCellSh, txfCellNo, txfPhotoPath;
    private RadioButton rbtSecLevelH, rbtSecLevelN, rbtCellShareY, rbtCellShareN;
    private DatePicker dateEntry, dateRelease;
    private Button btnGoBack, btnChooseP, btnAdd;
    private FileChooser photoFile1 = new FileChooser();
    File photoFile;
    private Rectangle ImgRect;
    private ImageView ImgView;
    private Image img;

    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Pane AddPane = new Pane();

        lblPrsProfile = new Label("Add Prisoner");
        lblPrsProfile.setLayoutX(40);
        lblPrsProfile.setLayoutY(20);
        lblPrsProfile.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR,20));
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
        txfFName = new TextField();
        txfFName.setPrefColumnCount(15);
        txfFName.setLayoutX(180);
        txfFName.setLayoutY(100);
        txfFName.setEditable(true);
        txfFName.setOnAction(event -> {
             txfFName.getText();
        });
        txfFName.setOnKeyPressed(event -> {
               if(event.getCode().equals(KeyCode.ENTER)){
                   txfFName.getText();
                   txfMidName.requestFocus();}
        });
        txfMidName = new TextField();
        txfMidName.setPrefColumnCount(15);
        txfMidName.setLayoutX(180);
        txfMidName.setLayoutY(140);
        txfMidName.setEditable(true);
        txfMidName.setOnAction(event -> {
                txfMidName.getText();
        });
        txfMidName.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txfMidName.getText();
                txfLName.requestFocus();}
        });
        txfLName = new TextField();
        txfLName.setPrefColumnCount(15);
        txfLName.setLayoutX(180);
        txfLName.setLayoutY(180);
        txfLName.setEditable(true);
        txfLName.setOnAction(event -> {
              txfLName.getText();
        });
        txfLName.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txfLName.getText();
                dateEntry.requestFocus();}
        });
        dateEntry = new DatePicker();
        dateEntry.setLayoutX(180);
        dateEntry.setLayoutY(220);
        dateEntry.setEditable(true);
        dateEntry.setOnAction(event -> {
            dateEntry.getValue();
        });
        dateRelease = new DatePicker();
        dateRelease.setLayoutX(180);
        dateRelease.setLayoutY(260);
        dateRelease.setEditable(true);
        dateRelease.setOnAction(event -> {
            dateRelease.getValue();
        });
        rbtSecLevelH = new RadioButton("High");
        rbtSecLevelH.setLayoutX(180);
        rbtSecLevelH.setLayoutY(300);
        rbtSecLevelH.setOnAction(event -> {
            txfSecLev.setText("High");
        });
        rbtSecLevelN = new RadioButton("Normal");
        rbtSecLevelN.setLayoutX(230);
        rbtSecLevelN.setLayoutY(300);
        rbtSecLevelN.setOnAction(event -> {
            txfSecLev.setText("Normal");
        });
        ToggleGroup tgSecLev = new ToggleGroup();
           rbtSecLevelH.setToggleGroup(tgSecLev);
           rbtSecLevelN.setToggleGroup(tgSecLev);
        txfSecLev = new TextField();
            txfSecLev.setPrefColumnCount(5);
            txfSecLev.setLayoutX(300);
            txfSecLev.setLayoutY(300);
            txfSecLev.setEditable(false);
            txfSecLev.setOnAction(event ->{
                txfSecLev.getText();
            });
            txfSecLev.setOnKeyPressed(event -> {
                if(event.getCode().equals(KeyCode.ENTER)){
                    txfSecLev.getText();
                    txfCellSh.requestFocus();}
            });
        rbtCellShareY = new RadioButton("Yes");
        rbtCellShareY.setLayoutX(180);
        rbtCellShareY.setLayoutY(340);
        rbtCellShareY.setOnAction(event -> {
            txfCellSh.setText("Yes");
        });
        rbtCellShareN = new RadioButton("No");
        rbtCellShareN.setLayoutX(230);
        rbtCellShareN.setLayoutY(340);
        rbtCellShareN.setOnAction(event -> {
            txfCellSh.setText("No");
        });
        ToggleGroup tgCellShare = new ToggleGroup();
           rbtCellShareY.setToggleGroup(tgCellShare);
           rbtCellShareN.setToggleGroup(tgCellShare);
        txfCellSh = new TextField();
        txfCellSh.setPrefColumnCount(5);
        txfCellSh.setLayoutX(300);
        txfCellSh.setLayoutY(340);
        txfCellSh.setEditable(false);
        txfCellSh.setOnAction(event -> {
            txfCellSh.getText();
        });
        txfCellSh.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txfCellSh.getText();
                txfCellNo.requestFocus();
            }
        });
        txfCellNo = new TextField();
        txfCellNo.setPrefColumnCount(15);
        txfCellNo.setLayoutX(180);
        txfCellNo.setLayoutY(380);
        txfCellNo.setEditable(true);
        txfCellNo.setOnAction(event -> {
            txfCellNo.getText();
        });
        txfCellNo.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                txfCellNo.getText();
                btnAdd.requestFocus();
            }
        });
        ImgRect = new Rectangle(500,80,100,100);
            ImgRect.setStroke(Color.BLACK);
            ImgRect.setFill(Color.WHITE);
        img = new Image("imagesPP.jpeg");
        ImgView = new ImageView(img);
           ImgView.setFitHeight(99);
           ImgView.setFitWidth(99);
           ImgView.setLayoutX(500);
           ImgView.setLayoutY(80);
        btnChooseP = new Button("Choose Photo");
           btnChooseP.setLayoutX(605);
           btnChooseP.setLayoutY(150);
           btnChooseP.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,14));
           btnChooseP.setOnAction(event -> {
               FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpeg*"
                       ,"*.jpg*","*.png*");
               photoFile1.getExtensionFilters().add(imageFilter);
               photoFile = photoFile1.showOpenDialog(AddPrisoner);
               if(photoFile != null){
                   Image Img = new Image(photoFile.toURI().toString());
                   ImgView.setImage(Img);
               }
           });
        btnGoBack = new Button("Go Back");
        btnGoBack.setLayoutX(700);
        btnGoBack.setLayoutY(550);
        btnGoBack.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,14));
        btnGoBack.setOnAction(event -> {
            Prisoner Pris = new Prisoner();
            Pris.start(Pris.PrisonerStage);
            AddPrisoner.hide();
        });
        btnAdd = new Button("Add Prisoner");
        btnAdd.setLayoutX(70);
        btnAdd.setLayoutY(550);
        btnAdd.setFont(Font.font("Courier",FontWeight.BOLD,FontPosture.REGULAR,14));
        btnAdd.setOnAction(event -> {
            if(txfFName.getText().isEmpty())
                txfFName.setPromptText("Please Insert FirstName : ");
            else if(txfMidName.getText().isEmpty())
                txfMidName.setPromptText("Please Insert MiddleName : ");
            else if(txfLName.getText().isEmpty())
                txfLName.setPromptText("Please Insert LastName : ");
            else if(dateEntry.getValue().isAfter(dateRelease.getValue()))
                dateEntry.setPromptText("Please Correct Entry Date");
            else if(dateRelease.getValue().isBefore(dateEntry.getValue()))
                dateRelease.setPromptText("Please Correct Release Date");
            else if(txfSecLev.getText().isEmpty())
                txfSecLev.setPromptText("Insert Security Level");
            else if(txfCellSh.getText().isEmpty())
                txfCellSh.setPromptText("Insert Cell Sharing");
            else if(txfCellNo.getText().isEmpty())
                txfCellNo.setPromptText("Insert Cell Number");
            else if(photoFile.toURI().toString().isEmpty())
                btnChooseP.requestFocus();
            else {
                Alert AddAlert = new Alert(Alert.AlertType.CONFIRMATION);
                     AddAlert.setTitle("Add Prisoner");
                     AddAlert.setHeaderText(null);
                     AddAlert.setContentText("Are you sure adding this Prisoner ?");
                     Optional<ButtonType > action = AddAlert.showAndWait();
                     if(action.get()==ButtonType.OK){
                    Functions.insertData(txfFName.getText(), txfMidName.getText(), txfLName.getText(), dateEntry.getValue(), dateRelease.getValue()
                            , txfSecLev.getText(), txfCellSh.getText(), Integer.parseInt(txfCellNo.getText()), photoFile.toURI().toString());

                    Prisoner Prs = new Prisoner();
                    Prs.start(Prs.PrisonerStage);
                    AddPrisoner.hide();
                    Prs.Initialize();}
                }
        });
        btnAdd.setOnKeyPressed(event -> {
            if(event.getCode().equals(KeyCode.ENTER)){
                if(txfFName.getText().isEmpty())
                    txfFName.setPromptText("Please Insert FirstName : ");
                else if(txfMidName.getText().isEmpty())
                    txfMidName.setPromptText("Please Insert MiddleName : ");
                else if(txfLName.getText().isEmpty())
                    txfLName.setPromptText("Please Insert LastName : ");
                else if(dateEntry.getValue().isAfter(dateRelease.getValue()))
                    dateEntry.setPromptText("Please Correct Entry Date");
                else if(dateRelease.getValue().isBefore(dateEntry.getValue()))
                    dateRelease.setPromptText("Please Correct Release Date");
                else if(txfSecLev.getText().isEmpty())
                    txfSecLev.setPromptText("Insert Security Level");
                else if(txfCellSh.getText().isEmpty())
                    txfCellSh.setPromptText("Insert Cell Sharing");
                else if(txfCellNo.getText().isEmpty())
                    txfCellNo.setPromptText("Insert Cell Number");
                else if(photoFile.toURI().toString().isEmpty())
                    btnChooseP.requestFocus();
                else {
                    Alert AddAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    AddAlert.setTitle("Add Prisoner");
                    AddAlert.setHeaderText(null);
                    AddAlert.setContentText("Adding this Prisoner ?");
                    Optional<ButtonType > action = AddAlert.showAndWait();
                    if(action.get()==ButtonType.OK){
                        Functions.insertData(txfFName.getText(), txfMidName.getText(), txfLName.getText(), dateEntry.getValue(), dateRelease.getValue()
                                , txfSecLev.getText(), txfCellSh.getText(), Integer.parseInt(txfCellNo.getText()), photoFile.toURI().toString());

                        Prisoner Prs = new Prisoner();
                        Prs.start(Prs.PrisonerStage);
                        AddPrisoner.hide();
                        Prs.Initialize();}
                }
            }
        });
        AddPane.getChildren().addAll(lblPrsProfile,lblFName,lblMidName,lblLName,lblEntranceDate,lblReleaseDate,
                lblSecuLevel,lblCellShare,lblCellNo,txfFName,txfMidName,txfLName,dateEntry,dateRelease,rbtSecLevelH,
                rbtSecLevelN,txfSecLev,rbtCellShareY,rbtCellShareN,txfCellSh,txfCellNo,ImgRect,ImgView,btnChooseP,btnGoBack,btnAdd);

        Scene AddScene = new Scene(AddPane,800,600);

        AddPrisoner.setTitle("Prisoner Profile");
        AddPrisoner.setResizable(false);
        AddPrisoner.setScene(AddScene);
        AddPrisoner.show();
    }
}
