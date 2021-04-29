package care.ai.play2paycodingchallenge

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import care.ai.play2paycodingchallenge.fragments.EbayItemFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.
        beginTransaction()
            .replace(R.id.mainFragment, EbayItemFragment.newInstance())
            .commit()
    }


}