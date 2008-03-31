PV_DiffMags : UGen
{
	*new { arg bufferA, bufferB;
		^this.multiNew('control', bufferA, bufferB)
	}
}

FFTPower : UGen
{
	*kr { arg buffer, square=true;
		if(square.isKindOf(Boolean)){
			square = square.binaryValue
		};
		^this.multiNew('control', buffer, square)
	}
}

FFTFlatness : UGen
{
	*kr { arg buffer;
		"FFTFlatness is deprecated and will be removed. Use 'SpecFlatness' instead.".error;
		^this.multiNew('control', buffer)
	}
}

FFTPercentile : UGen
{
	*kr { arg buffer, fraction=0.5, interpolate=0;
		"FFTPercentile is deprecated and will be removed. Use 'SpecPcile' instead.".error;
		^this.multiNew('control', buffer, fraction, interpolate)
	}
}

FFTDiffMags : UGen
{
	*kr { arg bufferA, bufferB;
		^this.multiNew('control', bufferA, bufferB)
	}
}


FFTFlatnessSplitPercentile : MultiOutUGen {
	
	*kr { arg buffer, fraction=0.5;
		^this.multiNew('control', buffer, fraction)
	}
	init { arg ... theInputs;
		inputs = theInputs;
		^this.initOutputs(2, rate);
	}
}

FFTFlux : UGen
{
	*kr { arg buffer, normalise=1;
		^this.multiNew('control', buffer, normalise)
	}
}

FFTFluxPos : UGen
{
	*kr { arg buffer, normalise=1;
		^this.multiNew('control', buffer, normalise)
	}
}

FFTSubbandPower : MultiOutUGen {
	
	var <numbands;
	
	*kr { arg chain, cutfreqs, square=1, scalemode=1;
		cutfreqs = cutfreqs.copy.sort;
		// Note the extra arg inserted so the UGen knows how many freqs to expect
		^this.multiNew('control', chain, cutfreqs.size, square, scalemode, *cutfreqs)
	}
	init { arg ... theInputs;
		inputs = theInputs;
		numbands = inputs[1] + 1;
		^this.initOutputs(numbands, rate);
	}
}

FFTSubbandFlux : MultiOutUGen {
	
	var <numbands;
	
	*kr { arg chain, cutfreqs, posonly=0;
		cutfreqs.sort;
		// Note the extra arg inserted so the UGen knows how many freqs to expect
		^this.multiNew('control', chain, cutfreqs.size, posonly, *cutfreqs)
	}
	init { arg ... theInputs;
		inputs = theInputs;
		numbands = inputs[1] + 1;
		^this.initOutputs(numbands, rate);
	}
}

PV_MagLog : UGen 
{
	*new { arg buffer;
		^this.multiNew('control', buffer)
	}
}

PV_MagExp : UGen 
{
	*new { arg buffer;
		^this.multiNew('control', buffer)
	}
}

FFTPhaseDev : UGen
{
	*kr { |buffer, weight=0, powthresh=0.1|
		^this.multiNew('control', buffer, weight, powthresh)
	}
}
FFTComplexDev : UGen
{
	*kr { |buffer, rectify=0, powthresh=0.1|
		^this.multiNew('control', buffer, rectify, powthresh)
	}
}
FFTMKL : UGen
{
	*kr { |buffer, epsilon=1e-06|
		^this.multiNew('control', buffer, epsilon)
	}
}

PV_Whiten : UGen
{
	*new { | chain, trackbufnum, relaxtime=2, floor=0.1, smear=0, bindownsample=0 |
		^this.multiNew('control', chain, trackbufnum, relaxtime, floor, smear, bindownsample)
	}
}

FFTCentroid : UGen
{
	*kr { | buffer |
		^this.multiNew('control', buffer)
	}
}

FFTRumble : UGen
{
	*kr { | buffer, pitch=440, mode=0, normalise=0 |
		^this.multiNew('control', buffer, pitch, mode, normalise)
	}
}

FFTSubbandFlatness : MultiOutUGen {
	
	var <numbands;
	
	*kr { arg chain, cutfreqs;
		cutfreqs.sort;
		// Note the extra arg inserted so the UGen knows how many freqs to expect
		^this.multiNew('control', chain, cutfreqs.size, *cutfreqs)
	}
	init { arg ... theInputs;
		inputs = theInputs;
		numbands = inputs[1] + 1;
		^this.initOutputs(numbands, rate);
	}
}

FFTCrest : UGen
{
	*kr { | buffer, freqlo=0, freqhi=50000 |
		^this.multiNew('control', buffer, freqlo, freqhi)
	}
}

FFTSpread : UGen
{
	*kr { | buffer, centroid |
		^this.multiNew('control', buffer, centroid ?? { SpecCentroid.kr(buffer) } )
	}
}
