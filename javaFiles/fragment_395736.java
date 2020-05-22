module BasicFsm(
    input      clock,
    input      reset,
    input      a,
    input      b,
    output reg c
);

reg        state;
wire       nexstate;

localparam S_STATE1    = 1'b0; //Could name initial
localparam S_STATE2    = 1'b1; //Could name following

always @(posedge clock or posedge reset) begin
  if(reset) begin
    state <= S_STATE1;
  end
  else begin
    state <= nextstate
  end
end

//Combinatorial nextstate
always @* begin
  case(state) 
    S_STATE1    : 
     if ( b == 1'b1 ) begin
       nextstate = S_STATE2 ; 
     end
     else begin
       nextstate = state ; //Hold state
     end
    S_STATE2    : nextstate = state ; //locked up forever if you get here
    default     : nextstate = S_STATE1;
  endcase
end

//Combinatorial output
always @* begin
  c = (state == S_STATE2) && (a == 1'b1);
end