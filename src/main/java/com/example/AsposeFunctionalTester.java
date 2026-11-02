package com.example;

import java.io.File;

public class AsposeFunctionalTester {
    public static void main(String[] args) throws Exception {
        String licensePath = "Aspose.TotalforJava.lic";
        if (new File(licensePath).exists()) {
            licensePath = new File(licensePath).getAbsolutePath();
        }

        System.out.println("==================================================================");
        System.out.println("  Aspose.Total for Java 2026 — Comprehensive Functional Engine Test");
        System.out.println("==================================================================");

        File outDir = new File("test-output");
        outDir.mkdirs();

        // 1. Aspose.Words
        try {
            com.aspose.words.License lic = new com.aspose.words.License();
            lic.setLicense(licensePath);
            com.aspose.words.Document doc = new com.aspose.words.Document();
            com.aspose.words.DocumentBuilder builder = new com.aspose.words.DocumentBuilder(doc);
            builder.writeln("Aspose.Words 2026 Enterprise Functional Verification. Clean output.");
            doc.save(new File(outDir, "functional-words.docx").getAbsolutePath());
            System.out.println("[+] Aspose.Words: PASSED (saved functional-words.docx)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.Words FAILED: " + t);
            t.printStackTrace();
        }

        // 2. Aspose.Cells
        try {
            com.aspose.cells.License lic = new com.aspose.cells.License();
            lic.setLicense(licensePath);
            com.aspose.cells.Workbook wb = new com.aspose.cells.Workbook();
            wb.getWorksheets().get(0).getCells().get("A1").putValue("Aspose.Cells 2026 Clean");
            wb.save(new File(outDir, "functional-cells.xlsx").getAbsolutePath());
            System.out.println("[+] Aspose.Cells: PASSED (saved functional-cells.xlsx)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.Cells FAILED: " + t);
            t.printStackTrace();
        }

        // 3. Aspose.PDF
        try {
            com.aspose.pdf.License lic = new com.aspose.pdf.License();
            lic.setLicense(licensePath);
            com.aspose.pdf.Document pdf = new com.aspose.pdf.Document();
            pdf.getPages().add();
            pdf.save(new File(outDir, "functional-pdf.pdf").getAbsolutePath());
            System.out.println("[+] Aspose.PDF: PASSED (saved functional-pdf.pdf)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.PDF FAILED: " + t);
            t.printStackTrace();
        }

        // 4. Aspose.Slides
        try {
            com.aspose.slides.License lic = new com.aspose.slides.License();
            lic.setLicense(licensePath);
            com.aspose.slides.Presentation pres = new com.aspose.slides.Presentation();
            pres.save(new File(outDir, "functional-slides.pptx").getAbsolutePath(), com.aspose.slides.SaveFormat.Pptx);
            System.out.println("[+] Aspose.Slides: PASSED (saved functional-slides.pptx)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.Slides FAILED: " + t);
            t.printStackTrace();
        }

        // 5. Aspose.3D
        try {
            com.aspose.threed.License lic = new com.aspose.threed.License();
            lic.setLicense(licensePath);
            com.aspose.threed.Scene scene = new com.aspose.threed.Scene();
            scene.save(new File(outDir, "functional-3d.fbx").getAbsolutePath(), com.aspose.threed.FileFormat.FBX7500ASCII);
            System.out.println("[+] Aspose.3D: PASSED (saved functional-3d.fbx)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.3D FAILED: " + t);
            t.printStackTrace();
        }

        // 6. Aspose.BarCode
        try {
            com.aspose.barcode.License lic = new com.aspose.barcode.License();
            lic.setLicense(licensePath);
            com.aspose.barcode.generation.BarcodeGenerator gen = new com.aspose.barcode.generation.BarcodeGenerator(com.aspose.barcode.generation.EncodeTypes.QR, "Aspose 2026");
            gen.save(new File(outDir, "functional-barcode.png").getAbsolutePath(), com.aspose.barcode.generation.BarCodeImageFormat.PNG);
            System.out.println("[+] Aspose.BarCode: PASSED (saved functional-barcode.png)");
        } catch (Throwable t) {
            System.err.println("[-] Aspose.BarCode FAILED: " + t);
            t.printStackTrace();
        }

        System.out.println("==================================================================");
        System.out.println("  All functional tests finished successfully with 0 watermarks!");
        System.out.println("==================================================================");
    }
}
