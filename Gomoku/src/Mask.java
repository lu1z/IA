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
			HeuristicUtil.weight[6]),
	ZXXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	YXXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	ZXXXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			HeuristicUtil.weight[6]),
	XXZXX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4], //(2^0 + 2^1 + 2^11 + 2^3 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			HeuristicUtil.weight[6]),
	XXXZX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4],	//(2^0 + 2^1 + 2^2 + 2^12 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			HeuristicUtil.weight[6]),
	XZXXX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[10] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],	//(2^0 + 2^10 + 2^2 + 2^3 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			4,
			HeuristicUtil.weight[6]),
	ZXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3],
			4,
			HeuristicUtil.weight[6]),
	YXXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3],
			4,
			HeuristicUtil.weight[6]),
	ZXXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^2 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],
			4,
			HeuristicUtil.weight[6]),
	YXXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	ZXXZXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			HeuristicUtil.weight[6]),
	ZXXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^2 + 2^12 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	ZXZXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],
			3,
			HeuristicUtil.weight[6]),
	YXZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	ZXZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4] + HeuristicUtil.bitPower[14],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^4 + 2^14)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[4],
			3,
			HeuristicUtil.weight[6]),
	ZXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2],
			5,
			HeuristicUtil.weight[6]),
	YXXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2],
			5,
			HeuristicUtil.weight[6]),
	ZXXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12],	//(2^9 + 2^1 + 2^2 + 2^12)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[2] +  HeuristicUtil.bitPower[12],
			5,
			HeuristicUtil.weight[6]),
	ZXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3],
			4,
			HeuristicUtil.weight[6]),
	YXZXZ(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3],
			4,
			HeuristicUtil.weight[6]),
	ZXZXY(HeuristicUtil.bitPower[9] + HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[11] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],	//(2^9 + 2^1 + 2^11 + 2^3 + 2^13)
			HeuristicUtil.bitPower[1] + HeuristicUtil.bitPower[3] + HeuristicUtil.bitPower[13],
			4,
			HeuristicUtil.weight[6]),
	XZXZX(HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[10] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[12] + HeuristicUtil.bitPower[4],	//(2^0 + 2^10 + 2^2 + 2^12 + 2^4)
			HeuristicUtil.bitPower[0] + HeuristicUtil.bitPower[2] + HeuristicUtil.bitPower[4],
			4,
			HeuristicUtil.weight[6]);
	
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
