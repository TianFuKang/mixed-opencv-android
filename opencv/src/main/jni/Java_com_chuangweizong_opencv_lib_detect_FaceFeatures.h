#include <jni.h>

#ifndef __JTCLIP__
#define __JTCLIP__

#ifdef __cplusplus
extern "C" {
#endif

/*
 * Class:     com_opencv_TClip
 * Method:    crop
 * Signature: (Ljava/lang/String;Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
 */
JNIEXPORT void JNICALL Java_com_chuangweizong_opencv_lib_detect_FaceFeatures_FindFeatures(JNIEnv*, jobject, jlong addrGray, jlong addrRgba);
#ifdef __cplusplus
}
#endif

#endif