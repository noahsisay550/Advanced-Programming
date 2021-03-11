import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.time.LocalDate;

public class Functions {

    public static void insertData(String PFN, String PMN, String PLN, LocalDate Entry, LocalDate Release, String secLev,
                                  String cellSh, int cellNO, String photoFile ){
        String sql = "INSERT INTO Prisoner (FirstName,MiddleName,LastName,EntryDate,ReleaseDate,SecurityLevel,CellSharing,CellNo,Photo)" +
                "Values ('"+PFN+"', '"+PMN+"', '"+PLN+"', '"+Entry+"', '"+Release+"', '"+secLev+"', '"+cellSh+"', '"+cellNO+"', '"+photoFile+"')";
        String sqlLog = "INSERT INTO PrisonerLog (FirstName,MiddleName,LastName,EntryDate,ReleaseDate,SecurityLevel,CellSharing,CellNo)" +
                "Values ('"+PFN+"', '"+PMN+"', '"+PLN+"', '"+Entry+"', '"+Release+"', '"+secLev+"', '"+cellSh+"', '"+cellNO+"')";
        try{
            DatabaseConnection.dbExecuteQuery(sql);
            DatabaseConnection.dbExecuteQuery(sqlLog);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void updateProfile(){}

    public static void deletePrisoner(int PID){
        String sql = "Delete From Prisoner WHERE PrisonerId = '"+PID+"'";
        try{
            DatabaseConnection.dbExecuteQuery(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ObservableList<PrisonerTD> getAllPrsList(){
        String sqlAll = "SELECT * FROM Prisoner";
        ResultSet rsSet = null;
        try{
            rsSet = DatabaseConnection.dbExecueSelect(sqlAll);
        }catch (Exception e){
            e.printStackTrace();
        }
        ObservableList<PrisonerTD> PrsList = getPrisonerObj(rsSet);
        return PrsList;
    }
    private static ObservableList<PrisonerTD> getPrisonerObj(ResultSet rsSet){
        ObservableList<PrisonerTD> PrsList = FXCollections.observableArrayList();
        try {
            while(rsSet.next()){
                PrisonerTD PTD = new PrisonerTD();
                    PTD.setID(rsSet.getInt("PrisonerId"));
                    PTD.setFirstName(rsSet.getString("FirstName"));
                    PTD.setLastName(rsSet.getString("LastName"));
                    PTD.setCN(rsSet.getInt("CellNo"));
                    PrsList.add(PTD);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return PrsList;
    }

    public static ObservableList<PrisonerTD> searchById(int PID){
        String sqlSID ="SELECT * FROM Prisoner WHERE PrisonerId ='"+PID+"'";
        ResultSet rsSet = null;
        try{
            rsSet = DatabaseConnection.dbExecueSelect(sqlSID);
        }catch (Exception e){
            e.printStackTrace();
        }
        ObservableList<PrisonerTD> searchListID = getPrisonerObj(rsSet);
        return searchListID;
    }
    public static ObservableList<PrisonerTD> searchByFN(String PFN){
        String sqlSFN ="SELECT * FROM Prisoner WHERE FirstName ='"+PFN+"'";
        ResultSet rsSet = null;
        try{
            rsSet = DatabaseConnection.dbExecueSelect(sqlSFN);
        }catch (Exception e){
            e.printStackTrace();
        }
        ObservableList<PrisonerTD> searchListFN = getPrisonerObj(rsSet);
        return searchListFN;
    }
    public static ObservableList<PrisonerTD> searchByLN(String PLN){
        String sqlSLN = "SELECT * FROM Prisoner WHERE LastName ='"+PLN+"'";
        ResultSet rsSet = null;
        try{
            rsSet = DatabaseConnection.dbExecueSelect(sqlSLN);
        }catch (Exception e){
            e.printStackTrace();
        }
        ObservableList<PrisonerTD> searchListID = getPrisonerObj(rsSet);
        return searchListID;
    }
    public static ObservableList<PrisonerTD> searchByCN(int PCN){
        String sqlSCN = "SELECT * FROM Prisoner WHERE CellNo ='"+PCN+"'";
        ResultSet rsSet = null;
        try{
            rsSet = DatabaseConnection.dbExecueSelect(sqlSCN);
        }catch (Exception e){
            e.printStackTrace();
        }
        ObservableList<PrisonerTD> searchListID = getPrisonerObj(rsSet);
        return searchListID;
    }
}
