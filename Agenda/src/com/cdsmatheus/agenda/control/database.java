package com.cdsmatheus.agenda.control;
import com.cdsmatheus.agenda.model.contato;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database  extends SQLiteOpenHelper{
	public static final String DATABASE_NAME="agenda.db";
	public static final String TABLE_NAME="contato";
	public static final String COL_1="Nome";
	public static final String COL_2="Telefone";
	public static final String COL_3="Celular";
	public static final String COL_4="Endereco";
	public database(Context context) {
		// TODO Auto-generated constructor stub
		super(context, DATABASE_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String cmd="CREATE TABLE "+TABLE_NAME+" (id INTEGER, Nome TEXT NOT NULL, Telefone TEXT, Celular TEXT NOT NULL, Endereco TEXT, PRIMARY KEY(id AUTOINCREMENT))";
		db.execSQL(cmd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
		onCreate(db);
	}
	
	public boolean cadastraContato(contato Modelo) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValue = new ContentValues();
		contentValue.put(COL_1, Modelo.getNome().toString());
		contentValue.put(COL_2, Modelo.getTelefone().toString());
		contentValue.put(COL_3, Modelo.getCelular().toString());
		contentValue.put(COL_4, Modelo.getEndereco().toString());
		long result = db.insert(TABLE_NAME, null, contentValue);
		if (result == -1) {
			return false;
		}
		else {
			return true;
		}
	}
}
