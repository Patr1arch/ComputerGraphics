import java.lang.Math.*
import javax.swing.*
import java.util.Date
import kotlin.math.exp

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
            JLabel("-------------------"),
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
//        var samplenumber_ = JTextField("10000")
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date,
            JLabel("start time :"),
            time,
            JLabel("sampling rate :"),
            samplingrate_,
            JLabel("N (0)"),
            N0,
            JLabel("Кол-во элементов"),
            samplenumber_
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1")
//        var samplenumber_ = JTextField("10000")
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1")
//        var samplenumber_ = JTextField("10000")
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1")
//        val N0 = JTextField("5000")
//        var samplenumber_ = JTextField("10000")
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1")
//        val N0 = JTextField("5000")
//        var samplenumber_ = JTextField("10000")
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
            sgn = v6(date.text, time.text, samplenumber_.text.toInt(), samplingrate_.text, L.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v7") {
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("200")
//        var samplenumber_ = JTextField("10000")
        var L = JTextField("50") //период решетки
        var a = JTextField("1") //amplitude
        var t = JTextField("10") //width of envelope
        var f = JTextField("0.5") //frequency
        //var fd = JTextField("0.5") //frequency d
        var phi = JTextField("0") //phase
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"),
            samplenumber_, JLabel("Период :"), L, JLabel("амплитуда"), a, JLabel("ширина огибающей"), t,
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
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1000")
//        var samplenumber_ = JTextField("10000")
        var L = JTextField("50") //период решетки
        var a = JTextField("1") //amplitude
        var t = JTextField("1") //width of envelope
        var f = JTextField("1") //frequency
        var fo = JTextField("0.5") //envelope frequency
        var phi = JTextField("0") //phase
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"),
            samplenumber_, JLabel("Период :"), L, JLabel("амплитуда"), a, JLabel("ширина огибающей"), t,
            JLabel("частота"), f, JLabel("Частота несущей"), fo, JLabel("Фаза"), phi
        )
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Вводные параметры", JOptionPane.PLAIN_MESSAGE)

        if (result == JOptionPane.OK_OPTION) {
            if (f.text.toFloat() < 0 || f.text.toFloat() > f.text.toFloat() * samplingrate_.text.toFloat()) {
                println("frequency is wrong, result = $result")

            } else{
                sgn = v8(
                    date.text,
                    time.text,
                    samplenumber_.text.toInt(),
                    samplingrate_.text,
                    t.text.toDouble(),
                    a.text.toDouble(),
                    f.text.toDouble(),
                    fo.text.toDouble(),
                    phi.text.toDouble()
                )
            }

        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }
    if (v == "v9") {
//        val time = JTextField("00:00:00")
//        val date = JTextField("01-01-2020")
//        var samplingrate_ = JTextField("1000")
//        var samplenumber_ = JTextField("10000")
        var L = JTextField("50") //период решетки
        var a = JTextField("1") //amplitude
        var t = JTextField("1") //width of envelope
        var f = JTextField("1") //frequency
        var fo = JTextField("0.5") //envelope frequency
        var phi = JTextField("0") //phase
        var m = JTextField("0.5") //depth
        val inputs = arrayOf<JComponent>(
            JLabel("start date :"),
            date, JLabel("start time :"), time, JLabel("sampling rate :"),
            samplingrate_, JLabel("Кол-во элементов"),
            samplenumber_, JLabel("Период :"), L, JLabel("амплитуда"), a, JLabel("ширина огибающей"), t,
            JLabel("частота"), f, JLabel("Частота несущей"), fo, JLabel("Фаза"), phi, JLabel("Глубина"), m
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
                t.text.toDouble(),
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


//date: String, time: String, samplenumber_: Int, samplingrate_: String, T: Double, a: Double, f: Double, phi: Double
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

fun v8(date: String, time: String, samplenumber_: Int, samplingrate_: String, T: Double, a: Double, f: Double, fo: Double, phi: Double): Signal {
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


fun v9(date: String, time: String, samplenumber_: Int, samplingrate_: String, T: Double, a: Double, f: Double, fo: Double, phi: Double, m: Double): Signal {
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