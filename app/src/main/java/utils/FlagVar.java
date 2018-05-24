package utils;

import java.math.BigDecimal;

public interface FlagVar {

    //public int anchorID = 1;

    //sampling rate
    public int Fs = 48000;

    // buffer length to store the samples for the audiotrack (for play thread)
    public int bufferSize = 20480;
    // buffer length to process the samples for the audiorecorder (for the decoder thread)

    /*********** constant parameters ***************************/
    // the constant parameters for the signal representation
    public static final int UP_PREAMBLE = 1;
    public static final int DOWN_PREAMBLE = 2;
    public static final int UP_SYMBOL = 3;
    public static final int DOWN_SYMBOL = 4;

    // message type constant
    public static final int MESSAGE_TDOA = 50;
    int MESSAGE_GRAPH = 51;
    //public static final int

    /*****************************************************/

    /*****************************************************/
    // parameters for the preamble
    public float TPreamble = 0.04f;
    public int BPreamble = 4000;
    public int Fmin = 17500;
    public int Fmax = 21500;

    // parameter for the symbols
    public float TSymbol = 0.03f;
    public int BSymbol = 1000;
    public int [] FUpSymbol = new int[]{17500, 18500, 19500, 20500};
    public int [] FDownSymbol = new int[]{21500, 20500, 19500, 18500};
    public int numberOfSymbols = 4;

    // guard interval
    public float guardInterval = 0.005f;
    public int guardIntervalLength = (int)(new BigDecimal(guardInterval * Fs).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue());

    /*****************************************************/

    /***********************threshold parameters*********************/
    public float preambleDetectionThreshold= 1f;
    public int numberOfPreviousSamples = 100;
    public float ratioThreshold = 2.5f;
    /*****************************************************/

    //becon message
    float beconMessageTime = TPreamble+guardInterval+TSymbol;
    int LPreamble = (int)(new BigDecimal(TPreamble*Fs).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue());
    int LSymbol = (int)(new BigDecimal(TSymbol*Fs).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue());
    int beconMessageLength = (int)(new BigDecimal(beconMessageTime*Fs).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue());


    /*************************String value for message exchanging*****************************/
    String upStr = "up";
    String downStr = "down";
    String tdoaStr = "tdoa";
    String anchorIdStr = "anchorId";
    String targetIdStr = "targetId";
    String xStr = "x";
    String yStr = "y";
    String identityStr = "identity";
    int cSound = 34000;
    float cSample = (float)cSound/Fs/2;

    int B_BUTTON_ENABLE = 1;
    int A_BUTTON_ENABLE = 2;
}