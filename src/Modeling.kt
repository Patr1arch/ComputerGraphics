import java.lang.Math.*
import javax.swing.*
import java.util.Date
import kotlin.math.exp
import kotlin.random.Random

fun InitModel(v: String, oldStartTime: String, oldStartDate: String, oldSamplingRate: String, oldSampleNumber: String): Signal {

    lateinit var sgn: Signal

    //var oldStartTime

    val time = JTextField(oldStartTime)
    val date = JTextField(oldStartDate)
    var samplingrate_ = JTextField(oldSamplingRate)
    var samplenumber_ = JTextField(oldSampleNumber)

    if (v == "v1") {
//        val time = JTextField(oldStartTime)
//        val date = JTextField(oldStartDate)
//        var samplingrate_ = JTextField(oldSamplingRate)
        val N0 = JTextField("5000")
        //var samplenumber_ = JTextField(oldSampleNumber)
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("N (0)"),
            N0
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v1(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text)
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v2") {
        val N0 = JTextField("5000")
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("N (0)"),
            N0
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v2(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text)
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v3") {
        var a = JTextField("1")
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Параметр убывания А (от 0 до 1) :"),
            a
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if ((result == JOptionPane.OK_OPTION) and (a.text.toFloat() >= 0) and (a.text.toFloat() <= 1)) {
            sgn = v3(date.text, time.text, samplenumber_.text.toInt(), samplingrate_.text, a.text.toFloat())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v4") {
        var a = JTextField("1") //амплитуда
        var w = JTextField("1") //круговая частота  от 0 до Pi
        var f = JTextField("1") //начальная фаза от 0 до 2 * Pi
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Амплитуда :"),
            a,
            JLabel("Круговая частота :"),
            w,
            JLabel("Начальная фаза :"),
            f
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v4(
                date.text,
                time.text,
                samplenumber_.text.toInt(),
                samplingrate_.text,
                a.text.toFloat(),
                w.text.toFloat(),
                f.text.toFloat()
            )
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v5") {
        var L = JTextField("50") //период решетки
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("Период :"),
            L
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v5(date.text, time.text, samplenumber_.text.toInt(), samplingrate_.text, L.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v6") {
        var L = JTextField("50") //период решетки
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("Кол-во элементов"),
            samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Период :"),
            L
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v6(date.text, time.text, samplenumber_.text.toInt(), samplingrate_.text, L.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v7") {
        var L = JTextField("50") //период решетки
        var a = JTextField("1") //amplitude
        var t = JTextField("10") //width of envelope
        var f = JTextField("0.5") //frequency
        //var fd = JTextField("0.5") //frequency d
        var phi = JTextField("0") //phase
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"), samplingrate_,
            JLabel("Кол-во элементов"), samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Период :"), L, JLabel("амплитуда"), a, JLabel("ширина огибающей"), t,
            JLabel("частота несущей (от 0 до 0.5 дискритизации)"), f, JLabel("Фаза"), phi
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)

        if (result == JOptionPane.OK_OPTION) {
//            if (f.text.toFloat() < 0 || f.text.toFloat() > 0.05) {
//                println("frequency is wrong, result = $result")
//            }
            sgn = v7(
                date.text,
                time.text,
                samplenumber_.text.toInt(),
                samplingrate_.text,
                t.text.toDouble(),
                a.text.toDouble(),
                f.text.toDouble(),
                phi.text.toDouble()
            )
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v8") {
      //  var L = JTextField("50") //период решетки
        var a = JTextField("1") //amplitude
        var t = JTextField("1") //width of envelope
        var f = JTextField("1") //frequency of wave
        var fo = JTextField("0.5") //envelope frequency
        var phi = JTextField("0") //phase
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"), samplingrate_,
            JLabel("Кол-во элементов"), samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("амплитуда"), a,
            JLabel("частота огибающей"), fo, JLabel("Частота несущей"), f, JLabel("Фаза"), phi
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)

        if (result == JOptionPane.OK_OPTION) {
//date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Double, f: Double, fo: Double, phi: Double

                sgn = v8(
                    date.text,
                    time.text,
                    samplenumber_.text.toInt(),
                    samplingrate_.text,
                    a.text.toDouble(),
                    f.text.toDouble(),
                    fo.text.toDouble(),
                    phi.text.toDouble()
                )


        } else {

            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v9") {
        var a = JTextField("1") //amplitude
        var f = JTextField("1") //frequency of wave
        var fo = JTextField("0.5") //envelope frequency
        var phi = JTextField("0") //phase
        var m = JTextField("0.5") //depth
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"), samplenumber_,
            JLabel("--------------------------------------"),
           JLabel("амплитуда"), a,
            JLabel("частота огибающей"), fo,
            JLabel("Частота несущей"), f,
            JLabel("Фаза"), phi,
            JLabel("Индекс глубины модуляции (в интегрвале от 0 до 1)"), m
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)

        if (result == JOptionPane.OK_OPTION) {
//            if (f.text.toFloat() < 0 || f.text.toFloat() > 0.05) {
//                println("frequency is wrong, result = $result")
//            }
            sgn = v9(
                date.text,
                time.text,
                samplenumber_.text.toInt(),
                samplingrate_.text,
                a.text.toDouble(),
                f.text.toDouble(),
                fo.text.toDouble(),
                phi.text.toDouble(),
                m.text.toDouble()
            )
        } else {
            println("User canceled / closed the dialog, result = $result")

        }
    }

    if (v == "randomFunc1") {
        val a =  JTextField("0")
        val b = JTextField("0")
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"), samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Начальная точка интервала"), a,
            JLabel("Конечная точка интервала"), b
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = randomFunc1( date.text,
                time.text,
                samplenumber_.text.toInt(),
                samplingrate_.text,
                a.text.toDouble(),
                b.text.toDouble())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }
    if (v == "randomFunc2") {
        val a =  JTextField("0")
        val d = JTextField("0")
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"), samplenumber_,
            JLabel("--------------------------------------"),
            JLabel("Среднее"), a,
            JLabel("Дисперсия"), d
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = randomFunc2( date.text,
                time.text,
                samplenumber_.text.toInt(),
                samplingrate_.text,
                a.text.toDouble(),
                d.text.toDouble())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }

    }
        //date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Double, f: Double, fo: Double, phi: Double, m: Double
    return sgn

}

fun v1(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "delayed_single_pulse"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){

        if (i == N0.toInt()){
            sgn.arraChannels[0][i] = 100f
        }
    }
    return sgn
}

fun v2(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "delayed_single_jump"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){

        if (i >= N0.toInt()){
            sgn.arraChannels[0][i] = 100f
        }
    }
    return sgn
}

fun v4(date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Float, w: Float, f: Float): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "sinusoid"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){

        sgn.arraChannels[0][i] = (a * sin((i * w + f).toDouble())).toFloat()

    }
    return sgn
}

fun v3(date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Float): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "exponent"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = pow(a.toDouble(),i.toDouble()).toFloat()
    }
    return sgn
}

fun v5(date: String, time: String, samplenumber_: Int, samplingrate_: String, L: Int): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "meander"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){

        if (i%L < L/2) {
            sgn.arraChannels[0][i] = 1f
        }
        else {sgn.arraChannels[0][i] = -1f}

    }
    return sgn
}


fun v6(date: String, time: String, samplenumber_: Int, samplingrate_: String, L: Int): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "saw"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = (i%L)/L.toFloat()
    }
    return sgn
}

fun v7(date: String, time: String, samplenumber_: Int, samplingrate_: String, T: Double, a: Double, f: Double, phi: Double): Signal{
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "exponentEnvelope"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    var x = 0.0;
    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = ((a*exp(-(x.toDouble()/T))*cos(2*PI*f*x.toDouble()+phi)).toFloat())
        x += 1/samplingrate_.toFloat()
        println(sgn.arraChannels[0][i])
    }
    return sgn
}

fun v8(date: String, time: String, samplenumber_: Int, samplingrate_: String,
       a: Double, f: Double, fo: Double, phi: Double): Signal {
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "balanceEnvelope"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)
    var x = 0.0;
    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = (a*cos(2*PI*fo*x + phi) *cos(2*PI*f*x)).toFloat()
        x += 1/samplingrate_.toFloat()
        println(sgn.arraChannels[0][i])
    }
    return sgn
}


fun v9(date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Double,
       f: Double, fo: Double, phi: Double, m: Double): Signal {
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "tonEnvelope"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)
    var x = 0.0;
    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = (a*(1 + m*cos(2*PI*fo*x))*cos(2*PI*f*x + phi)).toFloat()
        x += 1/samplingrate_.toFloat()
        println(sgn.arraChannels[0][i])
    }
    return sgn
}

fun rand() : Double {
    return Random(System.nanoTime()).nextDouble(Double.MAX_VALUE - 0.0 + 1.0)
}

fun frand() : Double {
    return rand()/Double.MAX_VALUE
}

fun randomFunc1(date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Double, b: Double) : Signal {
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "tonEnvelope"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)
    for (x in 0 until samplenumber_){
        sgn.arraChannels[0][x] = (a + (b - a) * frand()).toFloat()
    }
    return sgn
}

fun normRand() : Double {
    var sum = 0.0
    for (i in 0..11) {
        sum += frand()
    }
    return sum - 6.0
}



fun randomFunc2(date: String, time: String, samplenumber_: Int, samplingrate_: String, a: Double, d: Double) : Signal {
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "tonEnvelope"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)
    for (x in 0 until samplenumber_){
        sgn.arraChannels[0][x] = (sqrt(a) + d * normRand()).toFloat()
    }
    return sgn
}

//fun sum(q: Int, b: Array<Double>, d: Double) : Double {
//    var res : Double = 0.0
//    for (i in 1..q) {
//        res += b[i - 1] * xfun(d)
//    }
//    return res
//}
//
//
//fun sum2(p: Int, a: Array<Double>, q: Int, b: Array<Double>, d: Double) : Double {
//    var res = 0.0
//    for (i in 1..p) {
//        res += a[p - 1] * yfun(q, b, d)
//    }
//}
//
//fun xfun(d : Double) : Double{
//    return  (d * normRand())
//}
//
//fun yfun(q: Int, b: Array<Double>, d: Double) : Double{
//    return xfun(d) + sum(q, b, d)
//}
//
//fun randomFunc3(date: String, time: String, samplenumber_: Int, samplingrate_: String, d: Double, p: Int, q: Int, a: Array<Double>, b: Array<Double>) : Signal {
//    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
//    val channelsnames = Array<String?>(1,{ i -> "tonEnvelope"})
//    val sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)
//    for (n in 0 until samplenumber_) {
//        sgn.arraChannels[0][x] = yfun().toFloat()
//    }
//    return sgn
//}