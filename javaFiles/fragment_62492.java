!    // 1. Using lambda function
!    for (int i=1; i<10; [](int i) {for (int j=2; j<10; ++j) printf("%dx%d=%2d ",j,i,i*j);}(i++)) printf("\n");
main(int, char**)()
main(int, char**)+22: movl   $0x1,-0xc(%ebp)
main(int, char**)+29: jmp    0x40172a <main(int, char**)+65>
main(int, char**)+31: movl   $0x40a06f,(%esp)
main(int, char**)+38: call   0x408248 <printf(char const*, ...)>
main(int, char**)+43: mov    -0xc(%ebp),%edx
main(int, char**)+46: incl   -0xc(%ebp)
main(int, char**)+49: lea    -0x15(%ebp),%eax
main(int, char**)+52: mov    %edx,(%esp)
main(int, char**)+55: mov    %eax,%ecx
main(int, char**)+57: call   0x4016a0 <operator()(int) const>
main(int, char**)+62: sub    $0x4,%esp
main(int, char**)+65: cmpl   $0x9,-0xc(%ebp)
main(int, char**)+69: setle  %al
main(int, char**)+72: test   %al,%al
main(int, char**)+74: jne    0x401708 <main(int, char**)+31>
!    
!    // 2. Using single for-loop
!    for (int i=1, j=2; i<10; i=(++j==10) ? i+1 : i, j=(j==10) ? 2 : j) printf("%dx%d=%2d%c",j,i,i*j,(j==9) ? '\n' : ' ');
main(int, char**)+76: movl   $0x1,-0x10(%ebp)
main(int, char**)+83: movl   $0x2,-0x14(%ebp)
main(int, char**)+90: jmp    0x4017a8 <main(int, char**)+191>
main(int, char**)+92: cmpl   $0x9,-0x14(%ebp)
main(int, char**)+96: jne    0x401752 <main(int, char**)+105>
main(int, char**)+98: mov    $0xa,%eax
main(int, char**)+103: jmp    0x401757 <main(int, char**)+110>
main(int, char**)+105: mov    $0x20,%eax
main(int, char**)+110: mov    -0x10(%ebp),%edx
main(int, char**)+113: imul   -0x14(%ebp),%edx
main(int, char**)+117: mov    %eax,0x10(%esp)
main(int, char**)+121: mov    %edx,0xc(%esp)
main(int, char**)+125: mov    -0x10(%ebp),%eax
main(int, char**)+128: mov    %eax,0x8(%esp)
main(int, char**)+132: mov    -0x14(%ebp),%eax
main(int, char**)+135: mov    %eax,0x4(%esp)
main(int, char**)+139: movl   $0x40a071,(%esp)
main(int, char**)+146: call   0x408248 <printf(char const*, ...)>
main(int, char**)+151: incl   -0x14(%ebp)
main(int, char**)+154: cmpl   $0xa,-0x14(%ebp)
main(int, char**)+158: jne    0x40178f <main(int, char**)+166>
main(int, char**)+160: mov    -0x10(%ebp),%eax
main(int, char**)+163: inc    %eax
main(int, char**)+164: jmp    0x401792 <main(int, char**)+169>
main(int, char**)+166: mov    -0x10(%ebp),%eax
main(int, char**)+169: mov    %eax,-0x10(%ebp)
main(int, char**)+172: cmpl   $0xa,-0x14(%ebp)
main(int, char**)+176: je     0x4017a0 <main(int, char**)+183>
main(int, char**)+178: mov    -0x14(%ebp),%eax
main(int, char**)+181: jmp    0x4017a5 <main(int, char**)+188>
main(int, char**)+183: mov    $0x2,%eax
main(int, char**)+188: mov    %eax,-0x14(%ebp)
main(int, char**)+191: cmpl   $0x9,-0x10(%ebp)
main(int, char**)+195: setle  %al
main(int, char**)+198: test   %al,%al
main(int, char**)+200: jne    0x401745 <main(int, char**)+92>