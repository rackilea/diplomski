/*
    a (pausable) linear equation over real time

        value = _speed * Date.now() + _offset;

        //when paused, it's simply: 
        value = _offset;

    so basically a clock, a stopwatch, a countdown, a gauge, ...

    since it is only a linear equation over time, it is independant of any interval.
    It computes the value (using Date.now()) whenever you ask for it. Wether this is ever frame or every hour.
*/
class Clock {
    constructor(value=Date.now(), speed=1){
        //state; changes only when YOU set one of the properties (value, paused or speed)
        this._offset = +value || 0;
        this._speed = +speed || 0;
        this._paused = true;

        //preparing a simple hook to get notified after the state has been updated (maybe to store the new state in the localStorage)
        this.onStateChange = undefined;
    }

    get value(){ 
        return this._paused? this._offset: this._speed*Date.now() + this._offset 
    }
    set value(arg){
        let value = +arg || 0;
        let offset = this._paused? value: value - this._speed * Date.now();

        if(this._offset !== offset){
            this._offset = offset;
            if(typeof this.onStateChange === "function") 
                this.onStateChange(this);
        }
    }

    get speed(){
        return this._speed
    }
    set speed(arg){
        let speed = +arg || 0;
        if(this._speed !== speed){
            if(!this._paused)
                this._offset += Date.now() * (this._speed - speed);
            this._speed = speed;
            if(typeof this.onStateChange === "function")
                this.onStateChange(this);
        }
    }

    get paused(){
        return this._paused
    }
    set paused(arg){
        let pause = !!arg;
        if(this._paused !== pause){
          this._offset += (pause? 1: -1) * this._speed * Date.now();
            this._paused = pause;
            if(typeof this.onStateChange === "function")
              this.onStateChange(this);
        }
    }

    time(){
        let value = this.value,v = Math.abs(value);
        return {
            value,
            //sign: value < 0? "-": "",
            seconds: Math.floor(v/1e3)%60,
            minutes: Math.floor(v/6e4)%60,
            hours: Math.floor(v/36e5)%24,
            days: Math.floor(v/864e5)
        }
    }

    valueOf(){
        return this.value;
    }   

    start(){
        this.paused = false;
        return this;        
    }
    stop(){
        this.paused = true;
        return this;
    }
}