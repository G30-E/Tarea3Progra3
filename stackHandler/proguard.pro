-dontoptimize
-dontshrink
-dontwarn

# Mantener el punto de entrada (main) para que siga funcionando
-keep public class umg.edu.gt.stackhandler.App {
    public static void main(java.lang.String[]);
}

# (Opcional recomendado) Mantener firmas y anotaciones para que no se rompa nada raro
-keepattributes *Annotation*,Signature,InnerClasses,EnclosingMethod,SourceFile,LineNumberTable

# (Opcional) Mantener constructores públicos (suele ayudar si luego agregas cosas)
-keepclassmembers class * {
    public <init>(...);
}
