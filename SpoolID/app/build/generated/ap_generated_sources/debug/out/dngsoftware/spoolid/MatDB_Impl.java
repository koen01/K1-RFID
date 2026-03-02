package dngsoftware.spoolid;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class MatDB_Impl implements MatDB {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Filament> __insertionAdapterOfFilament;

  private final EntityDeletionOrUpdateAdapter<Filament> __deletionAdapterOfFilament;

  private final EntityDeletionOrUpdateAdapter<Filament> __updateAdapterOfFilament;

  private final SharedSQLiteStatement __preparedStmtOfUpdatePosition;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public MatDB_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFilament = new EntityInsertionAdapter<Filament>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `filament_table` (`dbKey`,`filament_position`,`filament_name`,`filament_id`,`filament_vendor`,`filament_param`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Filament entity) {
        statement.bindLong(1, entity.dbKey);
        statement.bindLong(2, entity.position);
        if (entity.filamentName == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.filamentName);
        }
        if (entity.filamentID == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.filamentID);
        }
        if (entity.filamentVendor == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.filamentVendor);
        }
        if (entity.filamentParam == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.filamentParam);
        }
      }
    };
    this.__deletionAdapterOfFilament = new EntityDeletionOrUpdateAdapter<Filament>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `filament_table` WHERE `dbKey` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Filament entity) {
        statement.bindLong(1, entity.dbKey);
      }
    };
    this.__updateAdapterOfFilament = new EntityDeletionOrUpdateAdapter<Filament>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `filament_table` SET `dbKey` = ?,`filament_position` = ?,`filament_name` = ?,`filament_id` = ?,`filament_vendor` = ?,`filament_param` = ? WHERE `dbKey` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Filament entity) {
        statement.bindLong(1, entity.dbKey);
        statement.bindLong(2, entity.position);
        if (entity.filamentName == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.filamentName);
        }
        if (entity.filamentID == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.filamentID);
        }
        if (entity.filamentVendor == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.filamentVendor);
        }
        if (entity.filamentParam == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.filamentParam);
        }
        statement.bindLong(7, entity.dbKey);
      }
    };
    this.__preparedStmtOfUpdatePosition = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE filament_table SET filament_position =? WHERE filament_id =?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM filament_table";
        return _query;
      }
    };
  }

  @Override
  public void addItem(final Filament item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFilament.insert(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteItem(final Filament item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFilament.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateItem(final Filament item) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFilament.handle(item);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updatePosition(final int pos, final String filamentID) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdatePosition.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, pos);
    _argIndex = 2;
    if (filamentID == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, filamentID);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfUpdatePosition.release(_stmt);
    }
  }

  @Override
  public void deleteAll() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteAll.release(_stmt);
    }
  }

  @Override
  public int getItemCount() {
    final String _sql = "SELECT COUNT(dbKey) FROM filament_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getInt(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Filament> getAllItems() {
    final String _sql = "SELECT * FROM filament_table ORDER BY filament_position ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfDbKey = CursorUtil.getColumnIndexOrThrow(_cursor, "dbKey");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_position");
      final int _cursorIndexOfFilamentName = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_name");
      final int _cursorIndexOfFilamentID = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_id");
      final int _cursorIndexOfFilamentVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_vendor");
      final int _cursorIndexOfFilamentParam = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_param");
      final List<Filament> _result = new ArrayList<Filament>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Filament _item;
        _item = new Filament();
        _item.dbKey = _cursor.getInt(_cursorIndexOfDbKey);
        _item.position = _cursor.getInt(_cursorIndexOfPosition);
        if (_cursor.isNull(_cursorIndexOfFilamentName)) {
          _item.filamentName = null;
        } else {
          _item.filamentName = _cursor.getString(_cursorIndexOfFilamentName);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentID)) {
          _item.filamentID = null;
        } else {
          _item.filamentID = _cursor.getString(_cursorIndexOfFilamentID);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentVendor)) {
          _item.filamentVendor = null;
        } else {
          _item.filamentVendor = _cursor.getString(_cursorIndexOfFilamentVendor);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentParam)) {
          _item.filamentParam = null;
        } else {
          _item.filamentParam = _cursor.getString(_cursorIndexOfFilamentParam);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Filament> getFilamentsByVendor(final String filamentVendor) {
    final String _sql = "SELECT * FROM filament_table  WHERE filament_vendor = ? ORDER BY filament_position ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (filamentVendor == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, filamentVendor);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfDbKey = CursorUtil.getColumnIndexOrThrow(_cursor, "dbKey");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_position");
      final int _cursorIndexOfFilamentName = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_name");
      final int _cursorIndexOfFilamentID = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_id");
      final int _cursorIndexOfFilamentVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_vendor");
      final int _cursorIndexOfFilamentParam = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_param");
      final List<Filament> _result = new ArrayList<Filament>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Filament _item;
        _item = new Filament();
        _item.dbKey = _cursor.getInt(_cursorIndexOfDbKey);
        _item.position = _cursor.getInt(_cursorIndexOfPosition);
        if (_cursor.isNull(_cursorIndexOfFilamentName)) {
          _item.filamentName = null;
        } else {
          _item.filamentName = _cursor.getString(_cursorIndexOfFilamentName);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentID)) {
          _item.filamentID = null;
        } else {
          _item.filamentID = _cursor.getString(_cursorIndexOfFilamentID);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentVendor)) {
          _item.filamentVendor = null;
        } else {
          _item.filamentVendor = _cursor.getString(_cursorIndexOfFilamentVendor);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentParam)) {
          _item.filamentParam = null;
        } else {
          _item.filamentParam = _cursor.getString(_cursorIndexOfFilamentParam);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Filament getFilamentById(final String filamentID) {
    final String _sql = "SELECT * FROM filament_table WHERE filament_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (filamentID == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, filamentID);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfDbKey = CursorUtil.getColumnIndexOrThrow(_cursor, "dbKey");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_position");
      final int _cursorIndexOfFilamentName = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_name");
      final int _cursorIndexOfFilamentID = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_id");
      final int _cursorIndexOfFilamentVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_vendor");
      final int _cursorIndexOfFilamentParam = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_param");
      final Filament _result;
      if (_cursor.moveToFirst()) {
        _result = new Filament();
        _result.dbKey = _cursor.getInt(_cursorIndexOfDbKey);
        _result.position = _cursor.getInt(_cursorIndexOfPosition);
        if (_cursor.isNull(_cursorIndexOfFilamentName)) {
          _result.filamentName = null;
        } else {
          _result.filamentName = _cursor.getString(_cursorIndexOfFilamentName);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentID)) {
          _result.filamentID = null;
        } else {
          _result.filamentID = _cursor.getString(_cursorIndexOfFilamentID);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentVendor)) {
          _result.filamentVendor = null;
        } else {
          _result.filamentVendor = _cursor.getString(_cursorIndexOfFilamentVendor);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentParam)) {
          _result.filamentParam = null;
        } else {
          _result.filamentParam = _cursor.getString(_cursorIndexOfFilamentParam);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Filament getFilamentByName(final String filamentName) {
    final String _sql = "SELECT * FROM filament_table WHERE filament_name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (filamentName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, filamentName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfDbKey = CursorUtil.getColumnIndexOrThrow(_cursor, "dbKey");
      final int _cursorIndexOfPosition = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_position");
      final int _cursorIndexOfFilamentName = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_name");
      final int _cursorIndexOfFilamentID = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_id");
      final int _cursorIndexOfFilamentVendor = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_vendor");
      final int _cursorIndexOfFilamentParam = CursorUtil.getColumnIndexOrThrow(_cursor, "filament_param");
      final Filament _result;
      if (_cursor.moveToFirst()) {
        _result = new Filament();
        _result.dbKey = _cursor.getInt(_cursorIndexOfDbKey);
        _result.position = _cursor.getInt(_cursorIndexOfPosition);
        if (_cursor.isNull(_cursorIndexOfFilamentName)) {
          _result.filamentName = null;
        } else {
          _result.filamentName = _cursor.getString(_cursorIndexOfFilamentName);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentID)) {
          _result.filamentID = null;
        } else {
          _result.filamentID = _cursor.getString(_cursorIndexOfFilamentID);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentVendor)) {
          _result.filamentVendor = null;
        } else {
          _result.filamentVendor = _cursor.getString(_cursorIndexOfFilamentVendor);
        }
        if (_cursor.isNull(_cursorIndexOfFilamentParam)) {
          _result.filamentParam = null;
        } else {
          _result.filamentParam = _cursor.getString(_cursorIndexOfFilamentParam);
        }
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
