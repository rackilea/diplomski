.version 49 0
.class super public initializers
.super java/lang/Object

.field static final f F = 4.0F
.field static final i I
.field static i2 I
.field public final x Ljava/lang/Object;
.field public x2 Ljava/lang/Object;

.method public <init> : ()V
    .limit stack 2
    .limit locals 1
    aload_0
    invokespecial java/lang/Object <init> ()V
    aload_0
    aconst_null
    putfield initializers x Ljava/lang/Object;
    aload_0
    aconst_null
    putfield initializers x2 Ljava/lang/Object;
    return
.end method

.method public <init> : (I)V
    .limit stack 1
    .limit locals 2
    aload_0
    invokespecial initializers <init> ()V
    return
.end method

.method public <init> : (F)V
    .limit stack 2
    .limit locals 2
    aload_0
    invokespecial java/lang/Object <init> ()V
    aload_0
    aconst_null
    putfield initializers x Ljava/lang/Object;
    aload_0
    aconst_null
    putfield initializers x2 Ljava/lang/Object;
    return
.end method

.method static <clinit> : ()V
    .limit stack 1
    .limit locals 0
    getstatic java/lang/Integer TYPE Ljava/lang/Class;
    invokevirtual java/lang/Object hashCode ()I
    putstatic initializers i I
    iconst_4
    putstatic initializers i2 I
    return
.end method