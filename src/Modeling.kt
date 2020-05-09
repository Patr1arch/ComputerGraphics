import java.lang.Math.*
import javax.swing.*
import java.util.Date

fun InitModel(v: String): Signal{

    lateinit var sgn : Signal

    if (v == "v1"){
            val time = JTextField("00:00:00")
            val date = JTextField("01-01-2020")
            var samplingrate_ = JTextField("1")
            val N0 = JTextField("5000")
            var samplenumber_ = JTextField("10000")
            val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_)
            val result =
                JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
            if (result == JOptionPane.OK_OPTION) {
                sgn = v1(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text)
            } else {
                println("User canceled / closed the dialog, result = $result")
            }
    }

    if (v == "v2"){
        val time = JTextField("00:00:00")
        val date = JTextField("01-01-2020")
        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
        var samplenumber_ = JTextField("10000")
        val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_)
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v2(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text)
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v3"){
        val time = JTextField("00:00:00")
        val date = JTextField("01-01-2020")
        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
        var samplenumber_ = JTextField("10000")
        var a = JTextField("1") //период решетки
        val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_, JLabel("Значение элементов :"), a)
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if ((result == JOptionPane.OK_OPTION) and (a.text.toFloat() >= 0) and (a.text.toFloat() <= 1)) {
            sgn = v3(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text, a.text.toFloat())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v4"){
        val time = JTextField("00:00:00")
        val date = JTextField("01-01-2020")
        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
        var samplenumber_ = JTextField("10000")
        var a = JTextField("1") //амплитуда
        var w = JTextField("1") //круговая частота  от 0 до Pi
        var f = JTextField("1") //начальная фаза от 0 до 2 * Pi
        val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_, JLabel("Амплитуда :"), a, JLabel("Круговая частота :"), w, JLabel("Начальная фаза :"), f)
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v4(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text, a.text.toInt(), w.text.toInt(), f.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v5"){
        val time = JTextField("00:00:00")
        val date = JTextField("01-01-2020")
        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
        var samplenumber_ = JTextField("10000")
        var L = JTextField("50") //период решетки
        val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_, JLabel("Период :"), L)
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v5(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text, L.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    if (v == "v6"){
        val time = JTextField("00:00:00")
        val date = JTextField("01-01-2020")
        var samplingrate_ = JTextField("1")
        val N0 = JTextField("5000")
        var samplenumber_ = JTextField("10000")
        var L = JTextField("50") //период решетки
        val inputs = arrayOf<JComponent>(JLabel("start date :"), date, JLabel("sampling rate :"), samplingrate_, JLabel("start time :"), time, JLabel("N (0)"), N0, JLabel("Кол-во элементов"), samplenumber_, JLabel("Период :"), L)
        val result =
            JOptionPane.showConfirmDialog(null, inputs, "Взодные параметры", JOptionPane.PLAIN_MESSAGE)
        if (result == JOptionPane.OK_OPTION) {
            sgn = v6(date.text, time.text, samplenumber_.text.toInt(), N0.text, samplingrate_.text, L.text.toInt())
        } else {
            println("User canceled / closed the dialog, result = $result")
        }
    }

    return sgn
}

fun v1(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "delayed_single_pulse"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){
        val str = sgn.WhatTime(i)
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
        val str = sgn.WhatTime(i)
        if (i >= N0.toInt()){
            sgn.arraChannels[0][i] = 100f
        }
    }
    return sgn
}

fun v4(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String, a: Int, w: Int, f: Int): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "sinusoid"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){

        sgn.arraChannels[0][i] = (a * sin((i * w * f).toDouble())).toFloat()

    }
    return sgn
}

fun v3(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String, a: Float): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "exponent"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = pow(a.toDouble(),i.toDouble()).toFloat()
    }
    return sgn
}

fun v5(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String, L: Int): Signal{
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


fun v6(date: String, time: String, samplenumber_: Int, N0: String, samplingrate_: String, L: Int): Signal{
    /** эти 3 строчки создают сигнал из одного канала размером samplenumber_, скорее всего вам из менять не нужно!!!**/
    val arraChannels: Array<Array<Float>> = Array(1, { Array(samplenumber_, {0f}) })
    var channelsnames = Array<String?>(1,{ i -> "saw"})
    var sgn: Signal = Signal(1, samplenumber_, samplingrate_, date, time, arraChannels, "modeling", channelsnames)

    for (i in 0..samplenumber_-1){
        sgn.arraChannels[0][i] = (i%L)/L.toFloat()
    }
    return sgn
}