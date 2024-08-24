import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "RegistroMina.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableUsuarios = """
            CREATE TABLE Usuarios (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                Nombre TEXT,
                Rol TEXT,
                Email TEXT,
                Contraseña TEXT
            )
        """.trimIndent()
        db.execSQL(createTableUsuarios)

        val createTableEquipos = """
            CREATE TABLE Equipos (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                NombreDelEquipo TEXT,
                ContratistaID INTEGER
            )
        """.trimIndent()
        db.execSQL(createTableEquipos)

        val createTableTrabajo = """
            CREATE TABLE Trabajo (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                EquipoID INTEGER,
                FechaRegistro TEXT,
                CarrosLlenados INTEGER,
                MaterialExtraido REAL,
                RetencionTrapiche REAL,
                MaterialDistribuido REAL
            )
        """.trimIndent()
        db.execSQL(createTableTrabajo)

        val createTablePagos = """
            CREATE TABLE Pagos (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                MineroID INTEGER,
                TrabajoID INTEGER,
                CantidadPagada REAL,
                FechaPago TEXT
            )
        """.trimIndent()
        db.execSQL(createTablePagos)

        val createTableHistorial = """
            CREATE TABLE Historial (
                ID INTEGER PRIMARY KEY AUTOINCREMENT,
                UsuarioID INTEGER,
                Descripcion TEXT,
                Fecha TEXT
            )
        """.trimIndent()
        db.execSQL(createTableHistorial)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Usuarios")
        db.execSQL("DROP TABLE IF EXISTS Equipos")
        db.execSQL("DROP TABLE IF EXISTS Trabajo")
        db.execSQL("DROP TABLE IF EXISTS Pagos")
        db.execSQL("DROP TABLE IF EXISTS Historial")
        onCreate(db)
    }

}
