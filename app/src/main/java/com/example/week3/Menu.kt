package com.example.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val ds = mutableListOf<Restaurant>()
        ds.add(Restaurant(33760,"Du Miên Garden Cafe - Phan Văn Trị","7 Phan Văn Trị, P. 10",R.drawable.id33760))
        ds.add(Restaurant(978,"Country House Cafe","18C Phan Văn Trị, P. 10",R.drawable.id978))
        ds.add(Restaurant(82801,"Hẻm Spaghetti - Nguyễn Oanh","212/22 Nguyễn Oanh, P. 17",R.drawable.id82801))
        ds.add(Restaurant(149154,"Lava Coffee - Quang Trung","61 Quang Trung, P. 10",R.drawable.id149154))
        ds.add(Restaurant(194867,"Mì Cay Naga - 224 Phạm Văn Đồng","224 Phạm Văn Đồng, P.1",R.drawable.id194867))

        ds.add(Restaurant(25656,"City House Cafe - Sân Vườn Lãng Mạn","21 Huỳnh Khương An, P.5",R.drawable.id25656))
        ds.add(Restaurant(66844,"Nhi Nhi Quán - Đặc Sản Phan Rang","125/48 Lê Đức Thọ, P. 17",R.drawable.id66844))
        ds.add(Restaurant(33645,"Yuri Yuri - Ẩm Thực Hàn Quốc","358 Nguyễn Văn Nghi, P.7",R.drawable.id33645))
        ds.add(Restaurant(252442,"Trà Sữa Gong Cha - 貢茶 - Phan Văn Trị","595 Phan Văn Trị, P. 5",R.drawable.id252442))
        ds.add(Restaurant(12513,"Oasis Cafe","26/14 Phạm Văn Đồng, P.3",R.drawable.id12513))

        ds.add(Restaurant(199622,"Buzza Pizza - Emart Gò Vấp","Tầng Trệt Emart Gò Vấp - 366 Phan Văn Trị, P. 5",R.drawable.id199622))
        ds.add(Restaurant(651063,"Dallas Cakes & Coffee - Quang Trung","6 Quang Trung, P. 10",R.drawable.id651063))
        ds.add(Restaurant(60915,"Hot & Cold - Trà Sữa & Xiên Que - Quang Trung","804 Quang Trung",R.drawable.id60915))
        ds.add(Restaurant(112585,"Papaxốt - Quang Trung","458 Quang Trung",R.drawable.id112585))
        ds.add(Restaurant(91979,"SaiGon Chic Cafe","82 Đường Số 27, P.6",R.drawable.id91979))

        ds.add(Restaurant(28883,"Pizza Hut - Quang Trung","283 Quang Trung",R.drawable.id28883))
        ds.add(Restaurant(129725,"Bánh Mì Chảo & Món Ngon Hoa Việt - Quán Cô 3 Hậu","36 Đường Số 18, P.8",R.drawable.id129725))
        ds.add(Restaurant(46668,"Kichi Kichi Lẩu Băng Chuyền - Quang Trung","1 Quang Trung",R.drawable.id46668))
        ds.add(Restaurant(158187,"The Coffee House - Quang Trung","293 Quang Trung",R.drawable.id158187))
        ds.add(Restaurant(30102,"Cánh Đồng Quán - Lẩu Nướng Tại Bàn - Dương Quảng Hàm","310/14 Dương Quảng Hàm, P.5",R.drawable.id30102))


        val adapterbb = Adapter(ds)
        rvDemo.adapter = adapterbb
        rvDemo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.layout_manager,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.LinearLayout -> {
                rvDemo.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                return true
            } R.id.GridLayout -> {
                rvDemo.layoutManager = GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false)
                return true
            } else -> super.onOptionsItemSelected(item)
        }


    }
}