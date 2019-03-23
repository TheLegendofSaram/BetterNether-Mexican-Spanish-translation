package paulevs.betternether.noise;

public class PermutationTable
{
	private char index1;
	private char index2;
	
	private static final char[] table = new char[]
			{
					404,  350,  334,   86,  283,   55,  174,   90,   30,  137,  363,  456,  303,  445,  107,  103, 
					 32,  471,   29,   48,  237,    2,  466,   25,  194,  182,   76,    3,  365,  222,  395,   35, 
					 80,  418,  438,  212,  351,   98,   20,   39,  235,  188,  433,   43,   34,  461,  348,  213, 
					 49,  510,   59,  274,  393,   10,  195,   74,  117,  446,  157,  377,  465,  314,  304,  406, 
					402,  310,  375,  200,  388,  505,    6,  290,   17,  506,  244,  338,  175,  187,   71,   97, 
					346,  216,   70,  128,  261,  158,  102,  113,  258,   96,  147,  124,  341,  127,  225,  499, 
					 60,  448,  323,  166,  378,  148,  345,  371,  149,  144,  398,  134,   82,   88,  372,  485, 
					498,  320,  476,  379,  474,  396,  460,  397,  192,  294,  453,    9,  458,  295,   36,  417, 
					426,  203,  232,  414,  385,  509,  403,  198,  269,  125,  298,  226,  390,  140,  151,  367, 
					322,  173,   16,  473,  321,  155,  165,  285,   37,  308,  169,  357,  206,  455,  126,    0, 
					111,  481,   15,  201,  411,  129,  380,  464,  176,  278,  429,  207,  186,  234,   13,  108, 
					492,   61,  329,  267,  317,  209,  254,  233,  362,  472,  220,  185,  307,   40,  189,   12, 
					299,  145,  407,  257,  221,   66,  214,  199,  374,   52,  324,  218,  133,  130,  413,  255, 
					463,  391,  119,  408,  419,  330,   57,  276,  251,  259,    1,  420,  184,  123,  296,  229, 
					 18,  452,   42,   45,  284,  300,  416,  305,  504,  423,  160,  266,  431,   84,  343,  159, 
					332,  412,  168,  170,   67,  355,  444,  163,  425,  138,  193,  256,  150,  289,  264,   46, 
					152,  366,   14,  361,  292,  370,  422,  231,  399,  316,  287,  469,   28,   58,  331,  223, 
					392,   87,  442,  239,  291,  196,   33,  415,  263,    7,  306,  421,  489,  270,  434,  389, 
					325,  497,   79,  369,  394,  180,  183,  457,  410,  109,  488,  211,  360,  447,   50,  156, 
					 19,  475,  335,   54,  405,  242,  432,  253,   63,  479,  275,  428,  260,   31,  337,  245, 
					141,  162,  358,  153,  105,  381,  116,  249,  340,  219,  135,  382,  161,   24,  480,   47, 
					339,  443,  191,  131,  503,  282,  342,  356,  112,  309,  230,  450,  177,    4,   56,   27, 
					 11,  501,  172,  383,  441,  484,  205,  349,  247,   75,  333,  486,  477,  297,  280,  164, 
					352,  114,  483,  459,  115,  190,  435,   44,  118,   93,  281,   26,   73,  178,  400,  279, 
					301,  430,  467,  250,    8,  353,   53,  436,   69,  427,  437,  344,  387,  286,  227,  500, 
					 91,   78,  241,  496,   22,  122,   38,  252,  424,  136,  271,  265,  197,  313,   81,  508, 
					384,  311,  478,  121,  312,  493,   94,   51,  293,  224,  462,  146,  142,   68,  215,  202, 
					154,  204,  248,  217,  494,  139,  319,  143,  373,  106,   77,   95,  440,  167,  386,  487, 
					354,  454,  347,  110,  328,  302,   99,  409,  507,  482,  495,  243,  210,  449,  277,   41, 
					288,  326,  101,  490,  315,  268,   85,  468,  228,   83,  100,  376,  401,  208,  511,  327, 
					 72,  336,  179,   62,  246,   89,  273,  439,  318,  236,   65,  451,  171,  104,   23,  238, 
					132,  364,  120,   64,  262,  181,    5,  272,  359,  491,  502,  470,  368,  240,   92,   21
			};
	
	public PermutationTable(long seed)
	{
		index1 = (char) (seed & 511);
    	index2 = (char) ((seed - (index1 << 8)) & 511);
	}

	public char NextChar()
	{
		char result = (char) table[(table[index1 & 511] + index2) & 511];
		index1 = (char) ((index1 + 1) & 511);
		if (index1 == 0)
			index2 = (char) ((index2 + 1) & 511);
		return result;
	}
	
	public double NextDouble()
    {
    	return (double) NextChar() / 511D;
    }
    
    public char PosChar(int x, int y)
    {
    	return table[(table[x & 511] + y) & 511];
    }
    
    public char PosChar(int x, int y, int z)
    {
    	return table[(table[(table[x & 511] + y) & 511] + z) & 511];
    }
    
    public double PosReal(int x, int y)
    {
    	return (double) PosChar(x, y) / 511;
    }

	public double PosReal(int x, int y, int z)
	{
		return (double) PosChar(x, y, z) / 511;
	}
}
