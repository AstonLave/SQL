package uk.ac.solent.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class MyHelper(ctx:Context) : SQLiteOpenHelper(ctx, "MusicDB", null, 1){

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Hits(Id INT PRIMARY KEY, Title VARCHAR(255),Artist VARCHAR(255), Year INT)")
    }
    override fun onUpgrade(db:SQLiteDatabase, oldVersion:Int, newVersion:Int) {
        db.execSQL ("DROP TABLE IF EXISTS Hits")
        onCreate(db)
    }
    fun addSong(title:String, artist:String, year:Long) : Long{
        val db = getWritableDatabase()
        val stmt = db.compileStatement("INSERT INTO Hits(title, artist, year) VALUES (?, ?, ?)");
        stmt.bindString(1, title)
        stmt.bindString(2, artist)
        stmt.bindLong(3, year)
        val id = stmt.executeInsert()
        return id
    }
    fun findSong(id: Long) : Song? {
        val db = getReadableDatabase()
        val cursor = db.rawQuery ("SELECT * FROM Hits WHERE Id=?", arrayOf<String>("$id") )
        if (cursor.moveToFirst()){
            val S = Song(cursor.getString(cursor.getColumnIndex(columnName:"ID"))

        }
        cursor.close()
        return people
    }
}