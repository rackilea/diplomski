package master;

import com.dukascopy.api.system.ISystemListener;
import com.dukascopy.api.system.IClient;
import com.dukascopy.api.system.ClientFactory;
import com.dukascopy.api.*;

import java.awt.Color;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Array;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JFrame;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import singlejartest.JavaHttpsExample;


public class MainStopFromConsole {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainStopFromConsole.class);
    private static String jnlpUrl = "https://www.dukascopy.com/client/demo/jclient/jforex.jnlp";
    private static String userName = "DEMO2PRFwj";
    private static String password = "PRFwj";

    //static String[] columns = {"Open Time", "Id", "Label", "Comment", "Instrument", "Side", "Amount", "Original Amount", "Open Price", "Stop Loss", "Take Profit", "Profit (Pips)", "Profit Currency", "Profit in USD", "Commission", "Commission USD"};
    static String[] columns = {"Id", "Instrument", "Side", "Amount", "Open Price", "Stop Loss", "Take Profit"};
    //static String[][] data = {{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16"},

    static String[][] data = new String[50][11];
    //static String[][] data = null;
    //static JFrame jf = new JFrame();

    public static void main(String[] args) throws Exception {       


        //get the instance of the IClient interface
        final IClient client = ClientFactory.getDefaultInstance();
        //set the listener that will receive system events
        client.setSystemListener(new ISystemListener() {
            private int lightReconnects = 3;

            public void onStart(long procid) {
                //IConsole console = context.getConsole();
                LOGGER.info("Strategy started: ");  
            }

            public void onStop(long processId) {
                LOGGER.info("Strategy stopped: " + processId);  
                if (client.getStartedStrategies().size() == 0) {
                    System.exit(0);
                }
            }

            @Override
            public void onConnect() {
                LOGGER.info("Connected");
                lightReconnects = 3;
            }

            @Override
            public void onDisconnect() {
                LOGGER.warn("Disconnected");
                if (lightReconnects > 0) {
                    LOGGER.error("TRY TO RECONNECT, reconnects left: " + lightReconnects);
                    client.reconnect();
                    --lightReconnects;
                } else {
                    try {
                        //sleep for 10 seconds before attempting to reconnect
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        //ignore
                    }
                    try {
                        client.connect(jnlpUrl, userName, password);
                    } catch (Exception e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                }
            }
        });

        LOGGER.info("Connecting...");
        //connect to the server using jnlp, user name and password
        client.connect(jnlpUrl, userName, password);

        //wait for it to connect
        int i = 10; //wait max ten seconds
        while (i > 0 && !client.isConnected()) {
            Thread.sleep(1000);
            i--;
        }
        if (!client.isConnected()) {
            LOGGER.error("Failed to connect Dukascopy servers");
            System.exit(1);
        }

        //subscribe to the instruments
        Set<Instrument> instruments = new HashSet<Instrument>();
        instruments.add(Instrument.EURUSD);
        LOGGER.info("Subscribing instruments...");
        client.setSubscribedInstruments(instruments);

        //start the strategy
        LOGGER.info("Starting strategy");
        final long strategyId = client.startStrategy(new IStrategy(){
            public Instrument instrument = Instrument.EURUSD;
            private IConsole console;
            private IEngine engine;


            public void onStart(IContext context) throws JFException {        
                console = context.getConsole();    
                engine = context.getEngine();

            }
            public void onBar(Instrument instrument, Period period, IBar askBar, IBar bidBar) throws JFException {
                if ( instrument == this.instrument){
                    //console.getOut().println(" bar: " + period  + " " + askBar);
                }

            }

            public void onTick(Instrument instrument, ITick tick) throws JFException { 

                try {                   

                int xx = 0;
                //data[0][1] = "1";
                for(IOrder o : engine.getOrders()){
                    if(o.getProfitLossInUSD() != 987654231){
                        console.getOut().println("Order: " + o.getInstrument() + " " + o.getProfitLossInPips() + " " + o.getOrderCommand());

                        // Copy orders to array
                        String userHash = "1";
                        String positionOpenTime = "" + o.getFillTime();
                        String positionId = "" + o.getId();
                        String positionInstrument = "" + o.getInstrument();
                        String positionIsbuy = "" + o.getOrderCommand().isLong();
                        String positionVolume = "" + o.getAmount();
                        String positionOpen = "" + o.getOpenPrice();
                        String positionSl = "" + o.getStopLossPrice(); 
                        String positionTp = "" + o.getTakeProfitPrice();
                        String positionComment = "" + o.getComment();

                        data[xx][0] = userHash;
                        data[xx][1] = positionOpenTime;
                        data[xx][2] = positionId;
                        data[xx][3] = positionInstrument;
                        data[xx][4] = positionIsbuy;
                        data[xx][5] = positionVolume;
                        data[xx][6] = positionOpen;
                        data[xx][7] = positionSl;
                        data[xx][8] = positionTp;
                        data[xx][9] = positionComment;
                        xx++;
                    }
                }
                xx=0;
                /*
                int i = 0;
                int j = 0;
                String string = "";
                for(j = 0; j<10; j++){
                for(i = 0; i<10; i++){
                    string += data[j][i] + "#"; 

                }
                string += "$$";
                }


                }


                console.getOut().println("=====================================================================================" );
                console.getOut().println(string);
                */

                console.getOut().println("=====================================================================================" );
                String txt ="";
                txt = Arrays.deepToString(data);
                txt = txt.replaceAll(",", "aa");
                txt = txt.replaceAll(" ", "zz");
                System.out.println(txt);
                console.getOut().println("=====================================================================================" );

                //=================================================================== send get == need commerciall ssl like startssl.com and serveralias and servername in virtualhost
                URL hp = new URL("https://breakermind.com/index.php?line="+txt);
                HttpsURLConnection hpCon = (HttpsURLConnection) hp.openConnection();

                boolean isProxy = hpCon.usingProxy();
                System.out.println("is using proxy " + isProxy);
                InputStream obj = hpCon.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(obj));

                String s;
                while ((s = br.readLine()) != null) {
                    s = s.replaceAll("zz", " ");
                    s = s.replaceAll("aa", ",");

                System.out.println(">>>" + s);
                }
                //===================================================================== end         

              } catch (Exception e) {
                  console.getErr().println(e.getMessage());
                  e.printStackTrace(console.getErr());
                 // context.stop();
              }

            console.getOut().println("=====================================================================================" );

            }
            public void onMessage(IMessage message) throws JFException {    }
            public void onAccount(IAccount account) throws JFException {    }
            public void onStop() throws JFException {    }
        });
        //now it's running

        //every second check if "stop" had been typed in the console - if so - then stop the strategy
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {    

                Scanner s = new Scanner(System.in);             
                while(true){
                    while(s.hasNext()){
                        String str = s.next();
                        if(str.equalsIgnoreCase("stop")){
                            System.out.println("Strategy stop by console command.");
                            client.stopStrategy(strategyId);
                        }
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            });
        thread.start();

    }
}