package com.mindorks.framework.soundboard

import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setUpUi()
        this.loadSound()
    }

    private fun setUpUi(){
        this.shootGun.setOnClickListener(this)
        this.shootSniper.setOnClickListener(this)
    }

    private fun loadSound(){
        this.mSoundPool = SoundPool.Builder().setMaxStreams(10).build()
        this.mSoundPool.setOnLoadCompleteListener{_,_,_ -> mLoaded = true}
        this.mSoundMap[R.raw.gun] = this.mSoundPool.load(this,R.raw.gun, 1)
        this.mSoundMap[R.raw.sniper] = this.mSoundPool.load(this,R.raw.sniper, 1)
    }

     override fun onClick(v:View){
        if (!this.mLoaded) return
        when (v.getId()){
            R.id.shootGun -> playSound(R.raw.gun)
            R.id.shootSniper -> playSound(R.raw.sniper)
        }
    }

    fun playSound(selectedSound:Int){
        val soundID = this.mSoundMap [selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f,1,0,1f)
    }
}