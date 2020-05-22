diff --git a/gfpcrypt.h b/gfpcrypt.h
index 7af993f..18ea104 100644
--- a/gfpcrypt.h
+++ b/gfpcrypt.h
@@ -408,7 +408,9 @@ CRYPTOPP_DLL_TEMPLATE_CLASS DL_PrivateKey_GFP<DL_GroupParameters_DSA>;
 CRYPTOPP_DLL_TEMPLATE_CLASS DL_PrivateKey_WithSignaturePairwiseConsistencyTest<DL_PrivateKey_GFP<DL_GroupParameters_DSA>, DSA2<SHA> >;

 //! the XOR encryption method, for use with DL-based cryptosystems
-template <class MAC, bool DHAES_MODE>
+// Set BC_COMPAT=true if interop'ing with Bouncy Castle. Thanks to Jesse Wilson and Daniele Perito.
+//   See https://groups.google.com/d/msg/cryptopp-users/vR8GSL8wxPA/Bf9koUDyZ88J.
+template <class MAC, bool DHAES_MODE, bool BC_COMPAT = false>
 class DL_EncryptionAlgorithm_Xor : public DL_SymmetricEncryptionAlgorithm
 {
 public:
@@ -442,9 +444,17 @@ public:
        mac.Update(encodingParameters.begin(), encodingParameters.size());
        if (DHAES_MODE)
        {
-           byte L[8] = {0,0,0,0};
-           PutWord(false, BIG_ENDIAN_ORDER, L+4, word32(encodingParameters.size()));
-           mac.Update(L, 8);
+           if (BC_COMPAT) {
+               byte L[4];
+               PutWord(false, BIG_ENDIAN_ORDER, L, word32(8 * encodingParameters.size()));
+               mac.Update(L, 4);
+           }
+           else
+           {
+               byte L[8] = {0,0,0,0};
+               PutWord(false, BIG_ENDIAN_ORDER, L+4, word32(encodingParameters.size()));
+               mac.Update(L, 8);
+           }
        }
        mac.Final(ciphertext + plaintextLength);
    }
@@ -471,9 +481,17 @@ public:
        mac.Update(encodingParameters.begin(), encodingParameters.size());
        if (DHAES_MODE)
        {
-           byte L[8] = {0,0,0,0};
-           PutWord(false, BIG_ENDIAN_ORDER, L+4, word32(encodingParameters.size()));
-           mac.Update(L, 8);
+           if (BC_COMPAT) {
+               byte L[4];
+               PutWord(false, BIG_ENDIAN_ORDER, L, word32(8 * encodingParameters.size()));
+               mac.Update(L, 4);
+           }
+           else
+           {
+               byte L[8] = {0,0,0,0};
+               PutWord(false, BIG_ENDIAN_ORDER, L+4, word32(encodingParameters.size()));
+               mac.Update(L, 8);
+           }
        }
        if (!mac.Verify(ciphertext + plaintextLength))
            return DecodingResult();