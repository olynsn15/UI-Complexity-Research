package com.example.thesisuiresearch.ui

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.thesisuiresearch.ui.model.Product

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "UIResearchDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("""
            CREATE TABLE products(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT,
                category TEXT,
                store TEXT,
                price INTEGER,
                rating REAL,
                sold INTEGER,
                location TEXT,
                stockStatus TEXT
            )
        """)

        insertDummy(db)
    }

    private fun insertDummy(db: SQLiteDatabase) {
        val data = listOf(
            "Wireless Headphone|Electronics|AudioMax|450000|4.2|1200|Jakarta|Available",
            "Tumbler Bottle|Home Goods|KitchenPro|85000|4.9|890|Bandung|Out of Stock",
            "Mechanical Keyboard|Computer Accessories|KeyPro|320000|4.5|500|Surabaya|Available",
            "Gaming Mouse|Computer Accessories|ClickZone|150000|4.6|750|Jakarta|Available",
            "Bluetooth Speaker|Electronics|SoundBeat|275000|4.3|620|Bandung|Available",
            "LED Desk Lamp|Home Goods|BrightLite|95000|4.4|300|Yogyakarta|Available",
            "Laptop Stand|Computer Accessories|ErgoTech|120000|4.7|410|Surabaya|Available",
            "Phone Holder|Accessories|GripIt|45000|4.1|980|Jakarta|Available",
            "USB Hub|Computer Accessories|ConnectX|80000|4.2|670|Bandung|Available",
            "Wireless Charger|Electronics|ChargeFast|110000|4.5|540|Jakarta|Available",
            "Backpack|Fashion|UrbanPack|230000|4.6|350|Surabaya|Available",
            "Smart Watch|Electronics|TimeTech|550000|4.3|210|Jakarta|Available",
            "Power Bank 10000mAh|Electronics|VoltPlus|140000|4.7|890|Bandung|Available",
            "Running Shoes|Fashion|RunFlex|300000|4.5|430|Jakarta|Available",
            "Coffee Mug|Home Goods|BrewCo|60000|4.8|760|Yogyakarta|Available",
            "Notebook Journal|Stationery|WriteWell|50000|4.6|520|Bandung|Available",
            "Office Chair|Furniture|ComfortSeat|750000|4.4|150|Jakarta|Available",
            "Table Fan|Home Appliances|CoolAir|180000|4.2|340|Surabaya|Available",
            "Portable SSD 512GB|Electronics|DataStore|620000|4.7|290|Jakarta|Available",
            "Yoga Mat|Fitness|FlexFit|95000|4.5|610|Bandung|Available"
        )

        for (d in data) {
            val p = d.split("|")
            db.execSQL("""
                INSERT INTO products(name,category,store,price,rating,sold,location,stockStatus)
                VALUES (?,?,?,?,?,?,?,?)
            """, p.toTypedArray())
        }
    }

    fun getProducts() : List<Product> {
        val list = mutableListOf<Product>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM products", null)

        while(cursor.moveToNext()) {
            list.add(
                Product(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getDouble(5),
                    cursor.getInt(6),
                    cursor.getString(7),
                    cursor.getString(8)
                )
            )
        }

        cursor.close()
        return list
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}