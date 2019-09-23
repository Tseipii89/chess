/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package chess;


// import chess.connection.EventPump;
import chess.engine.*;
import chess.model.*;
import chess.connection.*;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.IOException;
// import java.util.ArrayDeque;
// import java.util.logging.Level;
// import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        TestBot bot = new TestBot("INSERT TOKEN HERE");
        Long initialTime = System.currentTimeMillis();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (System.currentTimeMillis()-initialTime < 10000 && !in.ready()){}
            
            if (in.ready()){
                String input = in.readLine();
                if (input.equalsIgnoreCase("xboard")){
                    XBoardHandler xb = new XBoardHandler(bot);
                }
                
            } else {
                LichessAPI api = new LichessAPI(bot);
                
                Profile myProfile = api.getAccount();
                
                System.out.println("Profile ID: " + myProfile.id);
                
                api.beginEventLoop();
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
