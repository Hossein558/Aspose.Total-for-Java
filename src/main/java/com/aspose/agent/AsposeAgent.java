package com.aspose.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import javassist.*;
import javassist.expr.*;

/**
 * Universal Perpetual Enterprise License Agent for Aspose.Total for Java.
 * Intercepts license signature, date, and evaluation limiters across all 22 Aspose engines.
 */
public class AsposeAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        init(inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        init(inst);
    }

    private static void init(Instrumentation inst) {
        System.out.println("==================================================================");
        System.out.println("  [Aspose Java Enterprise Agent 2026] Active");
        System.out.println("  Universal Perpetual Activation: All 22 Aspose Modules Unlocked");
        System.out.println("==================================================================");

        inst.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(
                    ClassLoader loader,
                    String className,
                    Class<?> classBeingRedefined,
                    ProtectionDomain protectionDomain,
                    byte[] classfileBuffer) {

                if (className == null || !className.startsWith("com/aspose/")) {
                    return null;
                }

                try {
                    ClassPool cp = ClassPool.getDefault();
                    if (loader != null) {
                        cp.appendClassPath(new LoaderClassPath(loader));
                    }
                    cp.appendClassPath(new ByteArrayClassPath(className.replace('/', '.'), classfileBuffer));

                    CtClass cc = cp.get(className.replace('/', '.'));
                    if (cc.isInterface()) {
                        return null;
                    }

                    boolean modified = false;

                    // 1. Aspose.3D (com.aspose.threed.ie, iz & License)
                    if (className.equals("com/aspose/threed/ie") || className.equals("com/aspose/threed/iz")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("a") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            } else if (m.getName().equals("a") && m.getParameterTypes().length == 0 &&
                                       m.getReturnType().getName().equals("byte[]")) {
                                m.setBody("{\n" +
                                          "    try {\n" +
                                          "        return com.aspose.threed.iA.b;\n" +
                                          "    } catch (Throwable t) {\n" +
                                          "        return com.aspose.threed.if.b;\n" +
                                          "    }\n" +
                                          "}");
                                modified = true;
                            } else if (m.getName().equals("a") && m.getParameterTypes().length == 2 &&
                                       m.getParameterTypes()[0].getName().equals("java.lang.String")) {
                                m.setBody("{\n" +
                                          "    f = this;\n" +
                                          "    return;\n" +
                                          "}");
                                modified = true;
                            } else if (m.getName().equals("a") && m.getParameterTypes().length == 1 &&
                                       m.getParameterTypes()[0].getName().equals("java.io.InputStream")) {
                                m.setBody("{\n" +
                                          "    f = this;\n" +
                                          "    return;\n" +
                                          "}");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/threed/License")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("setLicense")) {
                                m.setBody("{ return; }");
                                modified = true;
                            }
                        }
                    }

                    // 2. Aspose.TeX (com.aspose.tex.License & I187)
                    if (className.equals("com/aspose/tex/License")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("setLicense")) {
                                m.setBody("{\n" +
                                          "    ll = true;\n" +
                                          "    com.aspose.tex.I187.lif = true;\n" +
                                          "    return;\n" +
                                          "}");
                                modified = true;
                            } else if (m.getName().equals("lif") && m.getParameterTypes().length == 0 &&
                                       m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/tex/I187")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("l0if") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        }
                    }

                    // 3. Aspose.Cells (com.aspose.cells.b0n & r0l)
                    if (className.equals("com/aspose/cells/b0n") || className.equals("com/aspose/cells/r0l")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("a") && m.getParameterTypes().length == 1 &&
                                m.getParameterTypes()[0].getName().equals("org.w3c.dom.Document")) {
                                m.instrument(new ExprEditor() {
                                    @Override
                                    public void edit(FieldAccess f) throws CannotCompileException {
                                        if (f.getFieldName().equals("c") && f.isReader()) {
                                            f.replace("{ $_ = null; }");
                                        }
                                    }
                                });
                                modified = true;
                            }
                        }
                    }

                    // 4. Aspose.Words (26.6 zzWc5, zzF5 & 26.8 zzWdb, zzXCp, zzOs)
                    if (className.equals("com/aspose/words/zzWc5")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzWVT") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return false; }");
                                modified = true;
                            } else if (m.getName().equals("zzYSb") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return false; }");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/words/zzF5")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzWVT") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return false; }");
                                modified = true;
                            } else if (m.getName().equals("zzYSb") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return false; }");
                                modified = true;
                            } else if (m.getName().equals("zzfQ") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/words/zzWdb") || className.equals("com/aspose/words/zzXCp")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if ((m.getName().equals("zzZdx") || m.getName().equals("zzXtw")) && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return false; }");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/words/zzOs")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzZTg") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            } else if (m.getName().equals("zzZdf") && m.getReturnType().getName().equals("byte[]")) {
                                m.setBody("{ return com.aspose.words.zzVWz.zzZXL; }");
                                modified = true;
                            }
                        }
                    }
                    if (className.equals("com/aspose/words/zzYgg")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzWaz") || m.getName().equals("zzYNw") || m.getName().equals("zzYuK")) {
                                m.setBody("{ return; }");
                                modified = true;
                            } else if ((m.getName().equals("zzX3P") || m.getName().equals("zzYdr")) && m.getReturnType().getName().equals("byte[]")) {
                                m.setBody("{ return com.aspose.words.zzVT1.zzX40; }");
                                modified = true;
                            }
                        }
                    }

                    // 5. Aspose.Words (zzIz)
                    if (className.equals("com/aspose/words/zzIz")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzfQ") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        }
                    }

                    // 6. Aspose.Words (zzZe6 - watermark suppression)
                    if (className.equals("com/aspose/words/zzZe6")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("zzZZQ") || m.getName().equals("zzPB")) {
                                m.setBody("{ zzYNp = 29273535023874148L; return; }");
                                modified = true;
                            } else if (m.getName().equals("zzQr") && m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        }
                    }

                    // 7. Aspose.Email (com.aspose.email.zajr)
                    if (className.equals("com/aspose/email/zajr")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            m.instrument(new ExprEditor() {
                                @Override
                                public void edit(MethodCall mc) throws CannotCompileException {
                                    if (mc.getMethodName().equals("op_GreaterThan") &&
                                        mc.getClassName().contains("DateTime")) {
                                        mc.replace("{ $_ = false; }");
                                    }
                                }
                            });
                            modified = true;
                        }
                    }

                    // 8. Aspose.Note (com.aspose.note.internal.ap.a)
                    if (className.equals("com/aspose/note/internal/ap/a")) {
                        for (CtMethod m : cc.getDeclaredMethods()) {
                            if (m.getName().equals("c") && m.getReturnType() == CtClass.intType) {
                                m.setBody("{ return 1; }");
                                modified = true;
                            }
                            m.instrument(new ExprEditor() {
                                @Override
                                public void edit(MethodCall mc) throws CannotCompileException {
                                    if (mc.getMethodName().equals("a") &&
                                        mc.getClassName().equals("com.aspose.note.internal.aq.z") &&
                                        mc.getSignature().equals("(Lcom/aspose/note/internal/aq/z;Lcom/aspose/note/internal/aq/z;)Z")) {
                                        mc.replace("{ $_ = false; }");
                                    }
                                }
                            });
                            modified = true;
                        }
                    }

                    // 9. General Date/Time ExprEditor across all aspose classes
                    final boolean[] exprModified = new boolean[]{false};
                    cc.instrument(new ExprEditor() {
                        @Override
                        public void edit(MethodCall mc) throws CannotCompileException {
                            String mName = mc.getMethodName();
                            String cName = mc.getClassName();
                            if ((mName.equals("before") || mName.equals("after")) && cName.equals("java.util.Date")) {
                                mc.replace("{ $_ = false; }");
                                exprModified[0] = true;
                            } else if (mName.equals("isAfter") && (cName.equals("java.time.LocalDate") || cName.endsWith("ChronoLocalDate"))) {
                                mc.replace("{ $_ = false; }");
                                exprModified[0] = true;
                            }
                        }
                    });
                    if (exprModified[0]) {
                        modified = true;
                    }

                    // 10. Universal License method overrides
                    try {
                        CtMethod m = cc.getDeclaredMethod("isLicensed", new CtClass[]{});
                        if (m.getReturnType() == CtClass.booleanType) {
                            m.setBody("{ return true; }");
                            modified = true;
                        }
                    } catch (NotFoundException ignored) {}

                    try {
                        CtMethod m = cc.getDeclaredMethod("isValidLicense", new CtClass[]{});
                        if (m.getReturnType() == CtClass.booleanType) {
                            m.setBody("{ return true; }");
                            modified = true;
                        }
                    } catch (NotFoundException ignored) {}

                    try {
                        CtMethod m = cc.getDeclaredMethod("isLicenseSet", new CtClass[]{});
                        if (m.getReturnType() == CtClass.booleanType) {
                            m.setBody("{ return true; }");
                            modified = true;
                        }
                    } catch (NotFoundException ignored) {}

                    if (className.endsWith("/License")) {
                        try {
                            CtMethod m = cc.getDeclaredMethod("isValid", new CtClass[]{});
                            if (m.getReturnType() == CtClass.booleanType) {
                                m.setBody("{ return true; }");
                                modified = true;
                            }
                        } catch (NotFoundException ignored) {}
                    }

                    try {
                        CtMethod m = cc.getDeclaredMethod("getEvaluationMessage", new CtClass[]{});
                        if (m.getReturnType() == cp.get("java.lang.String")) {
                            m.setBody("{ return \"\"; }");
                            modified = true;
                        }
                    } catch (NotFoundException ignored) {}

                    for (CtMethod m : cc.getDeclaredMethods()) {
                        if (m.getName().equals("verifySignature") && m.getReturnType() == CtClass.booleanType) {
                            m.setBody("{ return true; }");
                            modified = true;
                        }
                    }

                    if (modified) {
                        return cc.toBytecode();
                    }
                } catch (Throwable t) {
                    // Fall back to original bytecode on error
                }

                return null;
            }
        }, true);
    }
}
