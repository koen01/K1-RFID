package dngsoftware.spoolid;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class filamentDB_Impl extends filamentDB {
  private volatile MatDB _matDB;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `filament_table` (`dbKey` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `filament_position` INTEGER NOT NULL, `filament_name` TEXT, `filament_id` TEXT, `filament_vendor` TEXT, `filament_param` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '4b2fd9bba37e2732a94feda7bd7523a1')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `filament_table`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsFilamentTable = new HashMap<String, TableInfo.Column>(6);
        _columnsFilamentTable.put("dbKey", new TableInfo.Column("dbKey", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilamentTable.put("filament_position", new TableInfo.Column("filament_position", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilamentTable.put("filament_name", new TableInfo.Column("filament_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilamentTable.put("filament_id", new TableInfo.Column("filament_id", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilamentTable.put("filament_vendor", new TableInfo.Column("filament_vendor", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFilamentTable.put("filament_param", new TableInfo.Column("filament_param", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFilamentTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFilamentTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFilamentTable = new TableInfo("filament_table", _columnsFilamentTable, _foreignKeysFilamentTable, _indicesFilamentTable);
        final TableInfo _existingFilamentTable = TableInfo.read(db, "filament_table");
        if (!_infoFilamentTable.equals(_existingFilamentTable)) {
          return new RoomOpenHelper.ValidationResult(false, "filament_table(dngsoftware.spoolid.Filament).\n"
                  + " Expected:\n" + _infoFilamentTable + "\n"
                  + " Found:\n" + _existingFilamentTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "4b2fd9bba37e2732a94feda7bd7523a1", "dedf640d78bfe8ecb8093e94bd67343a");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "filament_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `filament_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(MatDB.class, MatDB_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public MatDB matDB() {
    if (_matDB != null) {
      return _matDB;
    } else {
      synchronized(this) {
        if(_matDB == null) {
          _matDB = new MatDB_Impl(this);
        }
        return _matDB;
      }
    }
  }
}
