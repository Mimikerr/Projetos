package com.example.softcom.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.softcom.data.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<Product>)

    @Query("SELECT * FROM product WHERE category = :category")
    fun getProductsByCategory(category: String): LiveData<List<Product>>

    @Query("SELECT * FROM product WHERE name LIKE '%' || :query || '%'")
    fun searchProducts(query: String): LiveData<List<Product>>

    @Query("DELETE FROM product")
    fun deleteAll(): Int
}
