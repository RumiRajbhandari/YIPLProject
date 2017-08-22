package com.example.root.yiplproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


    public class DatabaseHelper extends SQLiteOpenHelper {


        private static String DB_PATH = "";

        private static String DB_NAME = "dictionary 4.db";
    private static final int DATABASE_VERSION = 1;

        private SQLiteDatabase myDataBase;

        private final Context myContext;

        /**
         * Constructor
         * Takes and keeps a reference of the passed context in order to access to the application assets and resources.
         * @param context
         */
        public DatabaseHelper(Context context) {

            super(context, DB_NAME, null, DATABASE_VERSION);
            this.myContext = context;
            DB_PATH= myContext.getDatabasePath(DB_NAME).toString();
        }


        public void createDataBase() throws IOException {

            boolean dbExist = checkDataBase();

            if(dbExist){

            }else{


                this.getWritableDatabase();

                try {

                    copyDataBase();

                } catch (IOException e) {

                    throw new Error("Error copying database");

                }

            }

        }


        private boolean checkDataBase(){
         //  this.getReadableDatabase();

            SQLiteDatabase checkDB = null;

            try{
                String myPath = DB_PATH ;
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

            }catch(SQLiteException e){

                //database does't exist yet.

            }

            if(checkDB != null){

                checkDB.close();

            }

            return checkDB != null ? true : false;
        }


        private void copyDataBase() throws IOException {

            //Open your local db as the input stream
            InputStream myInput = myContext.getAssets().open(DB_NAME);

            // Path to the just created empty db
            String outFileName = DB_PATH ;

            //Open the empty db as the output stream
            OutputStream myOutput = new FileOutputStream(outFileName);

            //transfer bytes from the inputfile to the outputfile
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }

            //Close the streams
            myOutput.flush();
            myOutput.close();
            myInput.close();

        }

        public void openDataBase() throws SQLException {

            //Open the database
            String myPath = DB_PATH ;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);

        }

        @Override
        public synchronized void close() {

            if(myDataBase != null)
                myDataBase.close();

            super.close();

        }

        @Override
        public void onCreate(SQLiteDatabase db) {

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }



}

