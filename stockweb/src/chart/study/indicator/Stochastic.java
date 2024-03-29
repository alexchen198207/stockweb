package chart.study.indicator;

import chart.study.QuoteHistory;

/**
 * @author: Humberto Rocha Loureiro (humbertorocha@gmail.com)
 * @modify: 
 */

/**
 * Stochastic oscillator %K About:
 * http://en.wikipedia.org/wiki/Stochastic_oscillator
 */
public class Stochastic extends Indicator {
	private final int length;

	public Stochastic(QuoteHistory qh, int length) {
		super(qh);
		this.length = length;
	}

	@Override
	public double calculate() {
		int endBar = qh.size() - 1;
		int startBar = endBar - length;
		double max = 0;
		double min = qh.getPriceBar(startBar).getLow();
		double last;
		for (int bar = startBar; bar <= endBar; bar++) {
			max = Math.max(qh.getPriceBar(bar).getHigh(), max);
			min = Math.min(qh.getPriceBar(bar).getLow(), min);
		}
		last = qh.getPriceBar(endBar).getClose();
		value = (last - min) / (max - min) * 100;

		return value;
	}
}
