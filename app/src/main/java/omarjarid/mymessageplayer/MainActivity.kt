package omarjarid.mymessageplayer

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

// Piccola app che riproduce brevi file audio.
class MainActivity : AppCompatActivity() {
    /************************************* CAMPI **************************************************/
    /*
        SoundPool è una libreria che mi permette di gestire risorse audio per le app.
        Va bene dato che in questo progetto devo riprodurre brevi file audio.
    */
    private lateinit var soundPool:SoundPool

    // Gli ID dei file audio sono valori interi.
    private var sound1=0

    /************************************* METODI *************************************************/
    fun playSound(view:View) {
        when(view.id) {
            R.id.btnSound01 -> soundPool.play(
                sound1,
                1.0F,
                1.0F,
                0,
                0,
                1.0F
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Istanzio un oggetto SoundPool.
        val audioAttributes=AudioAttributes
            .Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()
        soundPool=SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        // Carico i suoni. (Qui in realtà ci vorrebbe tipo uno squillo di un telefono)
        sound1=soundPool.load(this, R.raw.sound01, 1)
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}