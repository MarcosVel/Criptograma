package apresentacao;

public class QuebraVigenere {
	private static final String CRIPTOGRAMA = "0053270f21331264022261252d01222f9b360367a853310b672c9a3009232e5320036722012d16332e14360721281264173224533115266106290767329a360f22611721462328152114222f07211567221a2214263253200367029a37073561112515222017251567241e640a223501251567251664132a205337032929126a4613331230076a3216640222610629076737163615a42e53370f2a311f2d002e2212200767251664132a205329072e3253230335201f64052e2701254623245337132532072d12322894a70967311c280f262d152504ae351a27076b611a2a10222f0725022661032b14670d162b082261312512332800300767001f260335351a64052233102546232453755271745d642767281d320329a6902b46232053270f21331264022261252d01222f9b360367a8532114352017250b222f0721462635012d0432ac17254626613128072e321664022261252d01222f9b36037c61162a05282f0736076a321664093528142d08262d1e210833245320033422012d122661032b1467061a2b10262f53060733280030076703162807342e532a0967321631462b280536096725123007232e532003677046715567221c2946286107a912322d1c642a2661102d0035205320032b6f53170f206f53030f2837122a460520072d1533205306032b20002b48670400300767221a221426619a640b3228072b46242e1d2c032428172546372e01351322619a6400a6221a2846232453340335221626033561166402226103b01467241e641635a0072d05266d5334073524102108232e5f6407673006210b6735162946372e062707673101a5122e22126846363416648f67281d3513222301a510222d536c0f292516270f21339232032b685d6425282f00211732241d30032a241d30036b611e310f332e006416352e1436072a20172b142232532d0b372d16290329351236072a6116371732241e251567251664053528033009203312220f26611d25156732062515672003280f242094b10334610231036732902b46292e53211534241d270f262d53270f2133123746232453120f20241dac14226d5321463634166415a42e53220724281f29032935166417322411360723200064162833533513262d023103356110360f37351c2508262d1a3712266f";
	private static final int TAMANHO_DA_SENHA = 6;
	private static final int GRUPO_DO_CARACTERE_DA_SENHA = 0;
	
	public static void main(String[] args) {
		int[] vetorDeFrequenciaDeCaracteres = new int[256];
		
		for (int i = 0; i < (CRIPTOGRAMA.length() - 1); i += 2) {
			String hexaDecimal = CRIPTOGRAMA.substring(i, i + 2);
			
			if (((i / 2) % TAMANHO_DA_SENHA) == GRUPO_DO_CARACTERE_DA_SENHA) {
				vetorDeFrequenciaDeCaracteres[Integer.parseInt(hexaDecimal, 16) ^ 32]++;				
			}			
		}
		
		for (int i = 0; i < vetorDeFrequenciaDeCaracteres.length; i++) {
			if (vetorDeFrequenciaDeCaracteres[i] > 0) {
				System.out.println(((char) i) + "\t" + vetorDeFrequenciaDeCaracteres[i]);
			}
		}
	}
}

// primeira chave:
// 05551b5f59310f200c11d9523f186e555f016a05275e5e172307214210162f552b5f431b241a6e5f515229143e58441326552a5e10022b983d1f103b24143b5645002b112111531d271a6e72551c3e07211154176a302042591c25551b5f591423162f555f522e106e73421339982258515267550d7465306a102311014b7c4d6211441d381b21441d012f552111400023182b58421d6a162b5f440025553b5f59042f073d584493381c211154136a072b565991255520501016a3162f5551522e106e0800522f553e50430125006e50101122142350425f39106e72551c3e072111651c23032b43431b3e943c585f522e106e73421339982258515267551b5f59310f200c1f103125186e545e01231b211154176a103652551ea01b2d5851522f553e5e5c9f3e1c2d5010162f553c545e1d3c14a9d25f523a103c5c511c2f1b3a541c522b55275f430623013b58d79125552f525f1f3a14205951522b066e54461d2600a9c455016a012b525e1d26862958531339552b1140172e1429c2571b29143d1f103d6a20205873371f376e5e561738102d5410113f073d5e435224143d11d1002f143d1154176a1627db5e1123143d115a0738982a58531339596e525998241627504352391a2d58511b39596e5259982416275043522f0d2f45510166552d58da1c291c2f4210162b553d50ca162f596e5259982416275043522e146e5454072914a9d25f522f553a54531c25192156591366552f5dd91f6a11214210113f073d5e43522e106e41c30167123c5054072b92ad5e101e2b012111555239013c58530625553d545e013f5b
// JuN10r ( eu acho )

// segunda chave:
// 0053270f21331264022261252d01222f9b360367a853310b672c9a3009232e5320036722012d16332e14360721281264173224533115266106290767329a360f22611721462328152114222f07211567221a2214263253200367029a37073561112515222017251567241e640a223501251567251664132a205337032929126a4613331230076a3216640222610629076737163615a42e53370f2a311f2d002e2212200767251664132a205329072e3253230335201f64052e2701254623245337132532072d12322894a70967311c280f262d152504ae351a27076b611a2a10222f0725022661032b14670d162b082261312512332800300767001f260335351a64052233102546232453755271745d642767281d320329a6902b46232053270f21331264022261252d01222f9b360367a8532114352017250b222f0721462635012d0432ac17254626613128072e321664022261252d01222f9b36037c61162a05282f0736076a321664093528142d08262d1e210833245320033422012d122661032b1467061a2b10262f53060733280030076703162807342e532a0967321631462b280536096725123007232e532003677046715567221c2946286107a912322d1c642a2661102d0035205320032b6f53170f206f53030f2837122a460520072d1533205306032b20002b48670400300767221a221426619a640b3228072b46242e1d2c032428172546372e01351322619a6400a6221a2846232453340335221626033561166402226103b01467241e641635a0072d05266d5334073524102108232e5f6407673006210b6735162946372e062707673101a5122e22126846363416648f67281d3513222301a510222d536c0f292516270f21339232032b685d6425282f00211732241d30032a241d30036b611e310f332e006416352e1436072a20172b142232532d0b372d16290329351236072a6116371732241e251567251664053528033009203312220f26611d25156732062515672003280f242094b10334610231036732902b46292e53211534241d270f262d53270f2133123746232453120f20241dac14226d5321463634166415a42e53220724281f29032935166417322411360723200064162833533513262d023103356110360f37351c2508262d1a3712266f
// AsDfG

//Exercicio 03 de criptografia
//Texto: 3e11335715520040105c125c115c52501411275d09de115d10113157015600551d115a122163341851c20555865c524414431a530b561c40141d5757164317579c571e510a13015d1f56025e04415e141e4310530b5a0855155e5757455e135a0558135d454317581011225c0cd01d18515457571647004105440553015c52511c1114531741175d03505b12065c1f141044035d0b5c1f5d1011184082521f511f4596400c525e1410551a5b0b5a01400350035b1352525151571e5c045d11511843161e45571b461445165f005d0651514202500a41165d1f50135d45521d143c58195b1647005b5155121220400655155e57560413384102451ed5041f5240145c57420a415252185f165e0c5713501411124a00411151031d57570813065b155e575d45471746035803c1175a1d141f50145b0a5d13585d111641455206461853025b82c6174751410557135a01401042575c0a13d514408157560a131346051f5703510752501011345d0b40065d05441ed5865c527214551240045f5e141f5e579545041d14155e575317475c144306575604133e511811195d4502421a4709441e455717144309575600131f55185e57560013400441025757491317470154145b035a11551c5419460009527d511c57531546005503111e5c034113d38454041215561c55184257510a5d0646101116120a4116511c11075d09de065d1250575745401d5718501b120a4652511c11135711411b59145f035d45571714135419414913015103471ed50a405251515819460041174702540412015252611f58945d455c07141554574110520114145f035b015216510211164711d200450458145316131714145c07400040134751418d50095a1155021d5750005e525502421e5f455c0740035004120c5d144610d68257161311411b50574217d2065d12505746005d1a5551431242004111410242945d455a1c401443124111521641105d575d10131b5a0554055c04501b5b1f501b120013174c185b161217560246144204d10a13075a1857184008565e14025410470b571d14025457560c40024102540512005e525814584c122c7a52195141055713561c5d0311121217560246185c1e40455c524003d0115b065c525d1ddc145b115c52501411125c115c00441452125c11560114141113400a5413475150115b0b405e141e11145d0b470055135019560a1317141e11135716501359185f1f5d455717141354194145565242105d184000405e1402541a121541175e04dc0d5d4557131410d6945d4555134e145f13d3175a131414111357455c0740035e0412964115d71e4257429f511e5d125e04120b520114035404420050065d07500412844117550211135745501d59015403d80b501b554a113e7b2c135f14144912400656001410425754105d95c1144257560013025b1ddc145b04131f5503dc035b08525e141054055d155c004004d0055b0413171415545754175c1c40145805531608527d27115a12004b17461254051e45501d5951540f510946015d0758135301565e1410425754105d95c1144257560013025b1ddc145b041318411558145b84411b5551551612305d1bd71e0a5764451e52571e58155b171313140544055004d4915b5154575d45560156045d1f5d45431d470254044196411b5b515518414551175a02111212015c011401439e560c5c0114155057670b5a915b51545756044052511f451e560457174751581946005400551f4512414557131410551a5b0b5a0140035090d10a1302ce135d1e510413145115540553091f5247145c5742175618419c4b181201525259105f0246005d95d71e111353455c0050145c57429f511e5d12505742005f13475161185e88501b5502113a5b095a065503540412015c011434420353015c010f515457642c135f141052185f15521c5c10435757455a1c47055002400441525d1f4002db175a065b021105570952115d1e5f16560a4052551e4257510a5d1458184518414552154690431e5d16131d415157025c015a9346185e041200131d475155125e004052501452184017561c4014425b121446135a155e574100130646104516404557171412431e5f001316515152185f155606de1f521e53455517501443165e491310511c111641165a1f1401431244005d1b46515457400043005d1c58051200400151021114400c5e17475f
//Senha: q1w2e3r4

//Exercicio 04 de criptografia
//Texto: 1a1d492209120d27071d2e0a0642310b49200d1414304e1a2a089c1627070a22455d1634030baa0855013d0f0422011a11750a0c63361c11210b0422165506304e2a2b040307753d002e8c01103c0d086f4516103c1e1d2c02070333070863011042360608350055983b070a2249550d204e0a310c05163a091b22031c03750a0c63061d03230b4930001610301a086a4506813a4e1c2e045501390f1a30005506304e082f021a103c1a042c165512341c0863045501270719370a121034080022495513200b493616140f750d0122131011750d1b2a15010d321c88250c1603264e1b260914013c010722011411751e0831045503264e0633000703b29b0c30451107750d00251714053003492645110736070f3104120738404902451a12301c08a4861a42310b49200d1414304e1a2a089c1627070a22459c42380f003045060b381e05261659422501003045050d310b49261d1c1121071b631018037594072a061442360608350055073b1a1b2645141175011926171485a00b1a6d453442360608350059423b0f49331794163c0d086f450707251c0c30001b16344e1c2e450607321c0c270a5942250f1b370c190a340a0663001b16270b492710141175011c6308140b264e19221701072642493210104225010d26085511301c4936161406341d49330407037503082d111010751b046306140c340249200a1b043c0a0c2d061c03394e0d26451c0c33011b2e0492813a40491616144f260b4936081442af0000200455013d0f1f26495512341c1d2a091d03310f49330a074234030b2c16550d264e002d11101039010a36111a10301d45630b1442251c0c2e0c0611344e0d26450417304e0c30111442bc4e0a2c0b1d0736070d224514123000083045050d274e0c2f00064c75211c37171a11751a0c31081a11751e0831045501270719370a121034080022451107750d0122131042260704aa11070b360f4930861a58750d1b2a15010d321c08250c1442310b49200d1414304e1a26060707210f4563011042360608350055983b070a22495506304e0a2b040307750d062e1514102107052b041103794e0d2645000f344e0a2b040307750b49270055013d0f1f264505103c180827045b421a4e1c300a55063a4e932f111c0f3a4e1d2617180d751e0627005582264e1f261f1011751d0c63061a0c331b07270c0742360104630a55013a03192c0b100c210b49200d1414304e19310c0303310f4927045501270719370a121034080022451107750d012213104225940b2f0c16037b4e286306070b251a06241714043c0f49270055013d0f1f2645060b38871d310c160375874933040703751d0c31450607250f1b22011442310b4920171c1221010e3104130b344e0d2645160a34180c630406113c038037171c013440
//Senha: UniCeub