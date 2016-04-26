/*
 * Z = aberta
 * Y = inimigo
 * X = voce
ZXXXXZ			quadra com 2 pontas abertas
YXXXXZ			quadra com 1 ponta aberta
ZXXXXY			quadra com 1 ponta aberta
XXZXX			quadra com 1 ponta aberta
XXXZX			quadra com 1 ponta aberta
XZXXX			quadra com 1 ponta aberta
ZXXXZ			trio com 2 pontas abertas
YXXXZ			trio com 1 ponta aberta
ZXXXY			trio com 1 ponta aberta
YXXZXZ			trio com 1 ponta aberta
ZXXZXY			trio com 1 ponta aberta
ZXXZXZ			trio com 1 ponta aberta
ZXZXXY			trio com 1 ponta aberta
YXZXXZ			trio com 1 ponta aberta
ZXZXXZ			trio com 1 ponta aberta
ZXXZ			dupla com 2 pontas abertas
YXXZ			dupla com 1 ponta aberta
ZXXY			dupla com 1 ponta aberta
ZXZXZ			dupla com 1 ponta aberta
YXZXZ			dupla com 1 ponta aberta
ZXZXY			dupla com 1 ponta aberta
XZXZX			dupla com 2 pontas abertas

TODO ORGANIZAR POR ORDEM DE PESO!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public enum Mask {
	XXXXX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],		//(2^0 + 2^1 + 2^2 + 2^3 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			1000000),
	ZXXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			35714),
	YXXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			13888),
	ZXXXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			13888),
	XXZXX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4], //(2^0 + 2^1 + 2^11 + 2^3 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			13888),
	XXXZX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4],	//(2^0 + 2^1 + 2^2 + 2^12 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			13888),
	XZXXX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[10] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],	//(2^0 + 2^10 + 2^2 + 2^3 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			13888),
	ZXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3],
			4,
			541),
	YXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3],
			4,
			144),
	ZXXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],
			4,
			144),
	YXXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			3,
			144),
	ZXXZXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			144),
	ZXXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			3,
			144),
	ZXZXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			144),
	YXZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			144),
	ZXZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			144),
	ZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2],
			5,
			10),
	YXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2],
			5,
			2),
	ZXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] +  HeuristicUtil.bitPower[12],
			5,
			2),
	ZXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3],
			4,
			2),
	YXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3],
			4,
			2),
	ZXZXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],
			4,
			2),
	XZXZX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[10] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4],	//(2^0 + 2^10 + 2^2 + 2^12 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			4,
			2);
	
	int mask;
	int value;
	int spatialRedundancy;
	int heuristic;
	
	Mask(int mask, int value, int spatialRedundancy, int heuristic) {
		this.mask = mask;
		this.value = value;
		this.spatialRedundancy = spatialRedundancy;
		this.heuristic = heuristic;
	}
}
