package com.pegalite.ff4kwallpaperimages;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.gms.ads.MobileAds;
import com.pegalite.ff4kwallpaperimages.ad.InterstitialAdManager;
import com.pegalite.ff4kwallpaperimages.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setStatusBar();

        MobileAds.initialize(this, initializationStatus -> {
        });

        InterstitialAdManager.loadAd(this);


        List<String> imageUrls = Arrays.asList(
                "https://drive.pegalite.com/api/shared/0f23338b-5ae6-4bda-949f-b4d3dd099467",
                "https://drive.pegalite.com/api/shared/9272e41b-38b3-4282-afa6-b7cbdccaaf6a",
                "https://drive.pegalite.com/api/shared/aaa7349e-0eac-4b1f-8824-d4c35eaa971f",
                "https://drive.pegalite.com/api/shared/a6635ce8-5577-44a8-bc14-9dc3a33814f8",
                "https://drive.pegalite.com/api/shared/8121cae7-a3e5-48a2-83e4-412a76c71958",
                "https://drive.pegalite.com/api/shared/6fe89739-258b-47da-9a99-ea42e7f4d4f0",
                "https://drive.pegalite.com/api/shared/40878118-475e-4b08-8a39-e4494fe229d4",
                "https://drive.pegalite.com/api/shared/afd55aa8-679b-42db-b885-4c84b638fd7b",
                "https://drive.pegalite.com/api/shared/e7f568f6-f63a-482f-8c3c-7ad170047f88",
                "https://drive.pegalite.com/api/shared/9263b45e-4864-4584-b4c3-63897bc92222",
                "https://drive.pegalite.com/api/shared/c64a6feb-c2b4-40ec-8f34-cb3bb6874b05",
                "https://drive.pegalite.com/api/shared/792d85c0-137c-4ad3-ad4f-b8969804b90b",
                "https://drive.pegalite.com/api/shared/37d7c2e9-7098-4463-9aff-96a442b9ef9c",
                "https://drive.pegalite.com/api/shared/00dd7932-2be4-4b47-a6f4-3f3543844277",
                "https://drive.pegalite.com/api/shared/7746301e-321d-47e5-b030-e8b705dc27cb",
                "https://drive.pegalite.com/api/shared/b8e07436-ebfe-4c95-9b22-de28b09279c5",
                "https://drive.pegalite.com/api/shared/deeccb96-e5b2-4b65-9e2d-8931d95f39dc",
                "https://drive.pegalite.com/api/shared/12a97802-3bea-4a36-9bb1-e69c9a7e79ce",
                "https://drive.pegalite.com/api/shared/08971729-ad72-4cf6-8bc8-04e9a8eee918",
                "https://drive.pegalite.com/api/shared/040e87d3-6622-4488-80d9-ebb7fafa344f",
                "https://drive.pegalite.com/api/shared/001e0c46-b384-4cbf-8190-4e33b0fdfc29",
                "https://drive.pegalite.com/api/shared/6b9273c1-3156-4cf7-b902-4d7823e59604",
                "https://drive.pegalite.com/api/shared/badf1c04-e396-47a4-add9-d598e8f80fe8",
                "https://drive.pegalite.com/api/shared/98fa6493-7f8d-4510-87a0-7233c746ce65",
                "https://drive.pegalite.com/api/shared/6fdf878a-bac4-4d9e-8f57-18c5265630f3",
                "https://drive.pegalite.com/api/shared/692cac3b-0f18-4776-bf6c-9b99474c8662",
                "https://drive.pegalite.com/api/shared/3ee3160b-0bc4-4db6-ba1f-7067685282cb",
                "https://drive.pegalite.com/api/shared/0534ac6d-0803-454e-8d58-f0db796cd16b",
                "https://drive.pegalite.com/api/shared/4ca7b262-ec20-40fc-bb94-b6481cbcdda7",
                "https://drive.pegalite.com/api/shared/ea3bfa4f-e667-4b54-9da7-81164f60c647",
                "https://drive.pegalite.com/api/shared/302db7c1-84f1-4631-9f4b-090ff7e6c40a",
                "https://drive.pegalite.com/api/shared/cfaa9c79-d73a-4d83-a46c-3d0901b862b4",
                "https://drive.pegalite.com/api/shared/a0c71935-c2b5-4fe9-9758-f74470d5c99b",
                "https://drive.pegalite.com/api/shared/0dd90723-5931-4442-91c3-dfe3ee5c7236",
                "https://drive.pegalite.com/api/shared/eed309ed-595c-4c64-a57a-76e80f971aa4",
                "https://drive.pegalite.com/api/shared/a7e03472-5b09-4fa5-b1bd-d1937cab9e6e",
                "https://drive.pegalite.com/api/shared/96481466-3833-45fb-a9a6-c38667231a4b",
                "https://drive.pegalite.com/api/shared/b0ac2c52-927e-4855-ab8e-6b3813c335fd",
                "https://drive.pegalite.com/api/shared/d39a00be-4c70-4bdc-8f64-ae909becb6ed",
                "https://drive.pegalite.com/api/shared/db5e01b2-d137-412b-8a80-86f7a18e41a0",
                "https://drive.pegalite.com/api/shared/14277aa3-5376-4d92-90ea-3683350d211d",
                "https://drive.pegalite.com/api/shared/cbaa582e-3d68-4102-ada2-334bdc666e28",
                "https://drive.pegalite.com/api/shared/7e25a79a-37a5-434f-b0e1-29b5918c5235",
                "https://drive.pegalite.com/api/shared/387483b9-faf0-4a32-a379-9b2a748e9db9",
                "https://drive.pegalite.com/api/shared/d09c5cb7-0836-4ede-a405-0322027eaf7c",
                "https://drive.pegalite.com/api/shared/d8322890-e18d-4623-bebe-15dfd76781cb",
                "https://drive.pegalite.com/api/shared/cac1fe6e-f505-44ec-9b95-6cacf2705f03",
                "https://drive.pegalite.com/api/shared/53cc5334-7a32-40e0-a87e-109cc62ea6b3",
                "https://drive.pegalite.com/api/shared/95c609c3-e458-40ac-8f4c-b967be05aa32",
                "https://drive.pegalite.com/api/shared/b1d5efc6-9688-40c7-80d3-e32349acbdc1",
                "https://drive.pegalite.com/api/shared/d1fdc216-563a-43d1-aa87-4d22f6944e05",
                "https://drive.pegalite.com/api/shared/de47738c-7eeb-449a-9755-bf3b77e79c11",
                "https://drive.pegalite.com/api/shared/7beb8f5a-f5d8-40be-a7c3-bdaaf3d375fe",
                "https://drive.pegalite.com/api/shared/7bdcd759-9ab8-44f7-ac0e-6421d4cd5e0f",
                "https://drive.pegalite.com/api/shared/3c75dc21-09ed-4771-a568-5ce030439355",
                "https://drive.pegalite.com/api/shared/b51b64a5-7b88-4251-a329-e395ff05f03c",
                "https://drive.pegalite.com/api/shared/4975fd4c-b2bc-4b7b-9a55-f7a741d241bf",
                "https://drive.pegalite.com/api/shared/d9c0ec51-09da-4841-ad8d-6119a7b3b89b",
                "https://drive.pegalite.com/api/shared/92bd5929-80f7-4b2c-899f-1f0bbd4a18c6",
                "https://drive.pegalite.com/api/shared/6ae8a081-7ca7-4fa7-9ce7-103eabb9dbda",
                "https://drive.pegalite.com/api/shared/0917433b-2382-4ee3-bf78-e9d7320d2970",
                "https://drive.pegalite.com/api/shared/6a39257d-6daf-49e2-a397-878c9f4ac7f4",
                "https://drive.pegalite.com/api/shared/8c2ac785-abc6-4070-a659-eec6b95c7897",
                "https://drive.pegalite.com/api/shared/490ed3ee-c58b-4de2-9554-327812b57194",
                "https://drive.pegalite.com/api/shared/50329877-5b2b-4e08-85c0-ffc319d1d93f",
                "https://drive.pegalite.com/api/shared/e309579e-af11-4ce8-99d0-d9fe6eff5fa3",
                "https://drive.pegalite.com/api/shared/6aa87d36-cfc1-4e2e-b520-b3adc97330d9",
                "https://drive.pegalite.com/api/shared/39a8ce23-95cb-49dd-9d23-d42d4c164024",
                "https://drive.pegalite.com/api/shared/dd7553b8-4082-408a-a083-b28e33d58dcc",
                "https://drive.pegalite.com/api/shared/a4294c3d-dec6-4bd8-86d6-5ef139ebcf28",
                "https://drive.pegalite.com/api/shared/2822514c-1634-4498-901a-12ec907eb772",
                "https://drive.pegalite.com/api/shared/86f4e39b-8fc0-4fb0-81fe-e20508fb91d8",
                "https://drive.pegalite.com/api/shared/c1b5c7b7-9e00-4417-ba6d-f504bf031821",
                "https://drive.pegalite.com/api/shared/f53d0f3b-43bc-4d49-bb1a-d423bf984544",
                "https://drive.pegalite.com/api/shared/8e6d4362-f3f8-48b9-923b-bfa23f07cd13", "https://drive.pegalite.com/api/shared/18676dc3-0f9c-4f9f-855f-36fbaf4ba33e",
                "https://drive.pegalite.com/api/shared/0532f73b-4529-4a7d-893c-ae5dcc3ec1df",
                "https://drive.pegalite.com/api/shared/ebb73151-9149-4381-9438-7eba58134b6b",
                "https://drive.pegalite.com/api/shared/09bdffda-dc15-4efc-aa9c-d111ae8a6d68",
                "https://drive.pegalite.com/api/shared/75ecd1bc-3fdf-43cc-a290-5ca0856fd0f9",
                "https://drive.pegalite.com/api/shared/2d8c0063-42f3-4c04-8663-685ec26041ab",
                "https://drive.pegalite.com/api/shared/f6a21134-895a-48d1-b4ef-afb95dd51b44",
                "https://drive.pegalite.com/api/shared/8e9fdfd0-3327-432c-b8de-b68e5f91cb96",
                "https://drive.pegalite.com/api/shared/cd8a6546-6475-4840-a3fd-74556923f71b",
                "https://drive.pegalite.com/api/shared/90ebce9e-a364-4880-87f1-b9210821416e",
                "https://drive.pegalite.com/api/shared/00f0ce43-8569-4946-8685-b86471dbb6e3",
                "https://drive.pegalite.com/api/shared/ebcb49c0-df94-4980-8de5-ecc57bc8a597",
                "https://drive.pegalite.com/api/shared/108677e7-7209-4f11-9de8-2cd1260d9e89",
                "https://drive.pegalite.com/api/shared/106a7546-ecfc-4203-b884-b6f50b158c1a",
                "https://drive.pegalite.com/api/shared/61af78ea-650b-4e8e-a300-dde0b9b9e973",
                "https://drive.pegalite.com/api/shared/11af0692-a226-4ac4-81aa-e65b769adc66",
                "https://drive.pegalite.com/api/shared/829eb9e9-e50d-4c18-b2ba-9b2606c6b8f9",
                "https://drive.pegalite.com/api/shared/bfb5fb4f-67e0-440b-85be-df9ac4fc01ee",
                "https://drive.pegalite.com/api/shared/94f8abd6-e09a-485f-b2b8-a223f3aa422a",
                "https://drive.pegalite.com/api/shared/c4ad1715-f4f6-49b2-825d-ab95c127bcda",
                "https://drive.pegalite.com/api/shared/756ab9ee-9636-41b8-ad20-bf5d5b623b19",
                "https://drive.pegalite.com/api/shared/e4cc5c1d-f587-4adb-9493-aeb8e348c002",
                "https://drive.pegalite.com/api/shared/f150937c-4a65-4b28-8fa9-4b0fb80fa3a7",
                "https://drive.pegalite.com/api/shared/17673209-ae8c-452f-8a88-853c79e3bb38",
                "https://drive.pegalite.com/api/shared/e18d695b-423c-4575-a923-f8bde9fc565b",
                "https://drive.pegalite.com/api/shared/903b1a11-1241-4bba-8e98-bc2fb3407415",
                "https://drive.pegalite.com/api/shared/ac06f3fd-eaa2-4a6a-94de-b68e199a5d95",
                "https://drive.pegalite.com/api/shared/90012157-db95-4dd7-a567-bea14671b44d",
                "https://drive.pegalite.com/api/shared/a24f894e-b573-4d5c-91fc-41a933d9e6d9",
                "https://drive.pegalite.com/api/shared/0559465a-7b46-4698-8c79-c05e8b9e761b",
                "https://drive.pegalite.com/api/shared/ed5fff9a-3a3f-493a-adfe-f8dbd78f4002",
                "https://drive.pegalite.com/api/shared/624b3164-e21a-4e09-8779-bc85daebb71d",
                "https://drive.pegalite.com/api/shared/a8a09e7f-8f34-4bce-b47c-145111e41ce4",
                "https://drive.pegalite.com/api/shared/04227af1-82ab-45e6-b023-7f8340239686",
                "https://drive.pegalite.com/api/shared/df6e2e08-665d-483c-8836-e3727375fe6b",
                "https://drive.pegalite.com/api/shared/393165f1-fb59-42e0-8674-06e009df9aa7",
                "https://drive.pegalite.com/api/shared/eb592168-35eb-4072-b97c-aa86f1d88342",
                "https://drive.pegalite.com/api/shared/439a8a07-8294-4610-83f1-d9b4c1e631b9",
                "https://drive.pegalite.com/api/shared/b28b4d1e-659b-48f7-aa39-e02e1b116b63",
                "https://drive.pegalite.com/api/shared/382ff56f-989f-4421-886c-d33bc3812447",
                "https://drive.pegalite.com/api/shared/a10303a0-ca33-4d24-90ee-15f9cdaa2ffb",
                "https://drive.pegalite.com/api/shared/2f53f86e-2db1-451b-ab8c-0d001c27e07e",
                "https://drive.pegalite.com/api/shared/ba948ae6-ecab-4dbb-8175-97d83ffd9eeb",
                "https://drive.pegalite.com/api/shared/a3da9755-63de-4364-b84a-90f8a865f70d",
                "https://drive.pegalite.com/api/shared/5014beaf-82d6-4c0c-8c8c-a48168b5eee6",
                "https://drive.pegalite.com/api/shared/eb436525-424d-4a7c-95d4-352cbe070b88",
                "https://drive.pegalite.com/api/shared/24d5801b-4d00-4289-8abe-7b8de6e8bc03",
                "https://drive.pegalite.com/api/shared/05ccd7cd-c0ac-4510-9794-3552498187a7",
                "https://drive.pegalite.com/api/shared/ca73d5b3-e3da-4b88-b6e3-80673186b388",
                "https://drive.pegalite.com/api/shared/e22a7f2c-052e-41c5-b5d5-93b337ac9310",
                "https://drive.pegalite.com/api/shared/baba6068-194a-4699-879f-d7b02dc55bbe",
                "https://drive.pegalite.com/api/shared/a3dc7fc3-5f87-47ec-8674-0a4db11af7bf",
                "https://drive.pegalite.com/api/shared/20806236-a3fd-40f1-a538-0510902133c7",
                "https://drive.pegalite.com/api/shared/5f3a1e63-29b6-4462-8bd3-6c325e96364c",
                "https://drive.pegalite.com/api/shared/a53db998-94f2-451e-ad4c-8cc8a66ae50a",
                "https://drive.pegalite.com/api/shared/6621adf8-27de-480a-b67b-854cbe42bca1",
                "https://drive.pegalite.com/api/shared/37ccbe00-543b-4149-9f41-a8d3bcd2e02f",
                "https://drive.pegalite.com/api/shared/8634413e-ebae-4783-9992-b236d9865865",
                "https://drive.pegalite.com/api/shared/3a43a305-c573-4c19-b73b-5b9e6e6681bb",
                "https://drive.pegalite.com/api/shared/136eece1-01cb-4745-889f-fba2c7e3363d",
                "https://drive.pegalite.com/api/shared/e3d4f28c-b2c0-4822-b082-9418acb740a0",
                "https://drive.pegalite.com/api/shared/6991344a-5524-425c-b011-9ac115711311",
                "https://drive.pegalite.com/api/shared/218369da-4ae7-4dd2-963b-41abe99d65c8",
                "https://drive.pegalite.com/api/shared/a79318bc-8d1a-40f1-bd0f-091319726c1c",
                "https://drive.pegalite.com/api/shared/4ff08152-243f-4272-84dd-e78996e132e4",
                "https://drive.pegalite.com/api/shared/ae2d5473-f767-45ec-9412-b9b56e877e83",
                "https://drive.pegalite.com/api/shared/df0fdd7e-32bc-46fc-bdd2-34c0db0a14a8",
                "https://drive.pegalite.com/api/shared/94bd9163-4bb8-4680-a507-604d35862dfe",
                "https://drive.pegalite.com/api/shared/7f775ccf-0aef-49c7-b7dc-f1221dd3e9fd",
                "https://drive.pegalite.com/api/shared/2ea76ff7-b25f-46c6-a898-306fe8adf62d",
                "https://drive.pegalite.com/api/shared/5c8ba3d8-6345-43bb-903f-c54a87cd3d81",
                "https://drive.pegalite.com/api/shared/82c4865d-f5c0-447e-af31-04906d2305e4",
                "https://drive.pegalite.com/api/shared/3a67e3cb-447f-427d-bfbf-af69af708c10",
                "https://drive.pegalite.com/api/shared/29b72554-ffac-4e51-ad20-08782b70169c",
                "https://drive.pegalite.com/api/shared/5d068882-002a-47c1-bf7f-974c61297878",
                "https://drive.pegalite.com/api/shared/d1a44cb9-2f7b-463b-ba51-e2b8fe4090d5",
                "https://drive.pegalite.com/api/shared/685b4fe3-22ed-4494-b0d3-b73e787918e0",
                "https://drive.pegalite.com/api/shared/13b66c52-f16b-43f5-a440-590f92908151",
                "https://drive.pegalite.com/api/shared/355c3c48-acca-47ac-9901-5dccc7b6f0fe",
                "https://drive.pegalite.com/api/shared/699cd337-d122-4e5f-a2cb-1e68413ca6d6",
                "https://drive.pegalite.com/api/shared/6cbb5467-885c-447a-a2e0-809be8512089",
                "https://drive.pegalite.com/api/shared/f8338214-ba9c-405b-b0da-6f66ef95135e",
                "https://drive.pegalite.com/api/shared/d7dd7c06-93b1-476c-95fa-a258848e8804",
                "https://drive.pegalite.com/api/shared/28702729-4ace-4aee-90dd-89b4caa6a2a3",
                "https://drive.pegalite.com/api/shared/7c05cc5e-3492-424c-a4d6-52d7eb9d2b50",
                "https://drive.pegalite.com/api/shared/b6d014d0-433c-489d-a4e9-932cbcfd7e82",
                "https://drive.pegalite.com/api/shared/3ab32033-3c48-451b-8b71-f93044e3e97b",
                "https://drive.pegalite.com/api/shared/25e12df5-b9c6-4ccb-bfc0-bdfb274b8d29",
                "https://drive.pegalite.com/api/shared/21ef2f87-4c04-4299-bf24-a0a910ed08ed",
                "https://drive.pegalite.com/api/shared/8679078b-4b63-4fb1-9f2d-a7e6ef19a5cb",
                "https://drive.pegalite.com/api/shared/1f8cc5db-176f-4768-bbf7-b8e854fb43dd",
                "https://drive.pegalite.com/api/shared/d2a01695-3993-4e45-895c-f9090c6fb9a9",
                "https://drive.pegalite.com/api/shared/c5fa2c2b-f324-41a4-96d3-378e5ae9c1bd",
                "https://drive.pegalite.com/api/shared/9311195a-c888-4b6f-8f23-606e758b13ce",
                "https://drive.pegalite.com/api/shared/81583c74-9ce5-4c21-8ed2-a19547c3a58b",
                "https://drive.pegalite.com/api/shared/f907dc82-6f4a-4dd4-b968-cb5be6e29f61",
                "https://drive.pegalite.com/api/shared/6937b805-8bef-40a4-b31c-42abded416a7",
                "https://drive.pegalite.com/api/shared/b5853e00-299e-46fd-a836-2b30e0b0d57d",
                "https://drive.pegalite.com/api/shared/36e32ce4-94cf-4472-a9a1-5317b3de532d",
                "https://drive.pegalite.com/api/shared/b475a082-4bdc-4aed-bb94-c1b4432e0755",
                "https://drive.pegalite.com/api/shared/3d96a2e7-f1af-4f92-a46c-474a5683c963",
                "https://drive.pegalite.com/api/shared/c36fce3f-1813-4459-9cfa-d4d1b46216a9",
                "https://drive.pegalite.com/api/shared/da624b17-1275-4370-90a0-83c4cc895403",
                "https://drive.pegalite.com/api/shared/c791586e-3d98-4d21-afea-8ed38fdf0de2",
                "https://drive.pegalite.com/api/shared/ef0a5447-9fa4-41ab-a380-f7e4855474c9",
                "https://drive.pegalite.com/api/shared/5783ed67-08fb-4471-b9c5-4403cdf14a50",
                "https://drive.pegalite.com/api/shared/2df600c4-cf39-4ff3-b91b-feb26caf97d3",
                "https://drive.pegalite.com/api/shared/ace819fb-96ce-4e86-972f-957cbc2065a3",
                "https://drive.pegalite.com/api/shared/e678f922-4335-470b-938f-d080bf9e1735",
                "https://drive.pegalite.com/api/shared/1e41207e-a893-4106-b785-9a0c9b71eddb",
                "https://drive.pegalite.com/api/shared/298c22d6-d08e-45ed-80e3-8ea30483fdd2",
                "https://drive.pegalite.com/api/shared/53039875-8878-4ee0-93b9-78c9780edeee",
                "https://drive.pegalite.com/api/shared/8d747f37-8d4a-485f-90aa-69b8ac9ad48c",
                "https://drive.pegalite.com/api/shared/8c488a04-b06c-4801-9ae9-1467e7f5ae76",
                "https://drive.pegalite.com/api/shared/3e007aaa-1b3e-4fd2-b9c5-4cf80f46a7cf",
                "https://drive.pegalite.com/api/shared/467a66b6-cb8b-4b7a-bee8-0b0e3c9b3b65",
                "https://drive.pegalite.com/api/shared/1a3cda88-4cd8-43a7-8271-b0aa2f0238b1",
                "https://drive.pegalite.com/api/shared/52ba584d-2455-4c5b-9150-f766a57f3733",
                "https://drive.pegalite.com/api/shared/9725e49b-9b26-4982-9754-e5bdf7ca308b",
                "https://drive.pegalite.com/api/shared/4f1a27b8-53df-449f-a27a-0f6fb2a84eb1",
                "https://drive.pegalite.com/api/shared/47b4a571-810a-4a96-8d25-025556d2eabd",
                "https://drive.pegalite.com/api/shared/b107ec1d-b86e-4970-ae01-cb5d56ff5677",
                "https://drive.pegalite.com/api/shared/e67a6998-ed83-4d2a-acf1-1446e1806eac",
                "https://drive.pegalite.com/api/shared/879e3eb8-3dc8-4974-91c4-caacc83b6cf6",
                "https://drive.pegalite.com/api/shared/f221b0d9-7fbf-48c7-96dd-705f4ce1b118",
                "https://drive.pegalite.com/api/shared/719a29f7-1576-4238-9c21-aab205742595",
                "https://drive.pegalite.com/api/shared/d7d49c2c-be12-4a90-9bdd-4dc0d4c51357",
                "https://drive.pegalite.com/api/shared/6d55b279-59dd-4b65-ab45-587025a459bf",
                "https://drive.pegalite.com/api/shared/583ea7fa-c6bd-456f-9605-7c852128f54b",
                "https://drive.pegalite.com/api/shared/3637d193-5830-458b-a436-1f3a2da51551",
                "https://drive.pegalite.com/api/shared/68b42d43-22fc-40fe-9198-42651e3455ed",
                "https://drive.pegalite.com/api/shared/aa0f511f-3793-448b-978f-aa64c7d6929b",
                "https://drive.pegalite.com/api/shared/6134e113-faf3-4ac2-9734-86adeaba3d8f",
                "https://drive.pegalite.com/api/shared/c7b0e60a-0f11-4364-ad3b-6fe658fe1070",
                "https://drive.pegalite.com/api/shared/f26b43ad-f72b-4653-af21-29e9cffccca6",
                "https://drive.pegalite.com/api/shared/69e10180-8647-4f75-9e36-e18149877665",
                "https://drive.pegalite.com/api/shared/aad356da-651b-40ef-b8a3-1dd0c39a980e",
                "https://drive.pegalite.com/api/shared/5ab5b90b-32a7-4e8d-8e79-8b3963b041d3",
                "https://drive.pegalite.com/api/shared/f42407cb-d330-4c8a-9719-92366faa00a2",
                "https://drive.pegalite.com/api/shared/545de9f3-d354-4431-83c0-261e3e4c1eec",
                "https://drive.pegalite.com/api/shared/309f3eb3-37ca-41ae-8bba-16e42e63becb",
                "https://drive.pegalite.com/api/shared/6591ef1e-2fb5-4855-a766-3b04597e21f6",
                "https://drive.pegalite.com/api/shared/901fb79d-247f-4df0-b0c3-d13bc3ccad8e",
                "https://drive.pegalite.com/api/shared/ab9858a2-4116-40ee-9d02-f3cb2ab0d668",
                "https://drive.pegalite.com/api/shared/c4eedd2f-b872-4381-8e6c-d5fbe95f0a49",
                "https://drive.pegalite.com/api/shared/302e7652-8004-4ae5-b94d-d976ac661893",
                "https://drive.pegalite.com/api/shared/7b7d3d96-ca59-4a81-b557-6bd6d545da57",
                "https://drive.pegalite.com/api/shared/3dcbbd2e-e0d7-4b4c-8589-df6f832ede69",
                "https://drive.pegalite.com/api/shared/e2a7ed3b-3b85-4c3d-a29c-76358b8b5d3a",
                "https://drive.pegalite.com/api/shared/55716fdf-cd99-4381-aded-474d0a2047b5",
                "https://drive.pegalite.com/api/shared/5201b81f-3d8d-4a14-b044-163e32ff5b4a",
                "https://drive.pegalite.com/api/shared/e8538c78-9ead-4c49-8666-e9b415e69e2a",
                "https://drive.pegalite.com/api/shared/ff16f5e1-ec9d-4908-9f8a-b0a934b26048",
                "https://drive.pegalite.com/api/shared/2f37c1b5-5c31-4d27-a740-a1bd0c58f4b1",
                "https://drive.pegalite.com/api/shared/0fd95050-43a3-45be-949e-81f55d604703",
                "https://drive.pegalite.com/api/shared/18f0ac23-c4ab-4d44-af0d-c09ce4d6064a",
                "https://drive.pegalite.com/api/shared/1d7e6e78-9d2d-4983-83ee-3a41b91aa664",
                "https://drive.pegalite.com/api/shared/a299d12e-e05f-4c77-9173-a3aaf26909ad",
                "https://drive.pegalite.com/api/shared/c4c4b993-f15a-4123-bca5-59eadfb88543",
                "https://drive.pegalite.com/api/shared/111d1abc-6799-47d7-8fde-afa2c62f7769",
                "https://drive.pegalite.com/api/shared/a648e14f-d673-4e76-927b-30342afccc3a",
                "https://drive.pegalite.com/api/shared/c11ecaff-7913-47ee-b5fc-085873682f4e",
                "https://drive.pegalite.com/api/shared/2904c8fd-8a73-4795-9a28-486c5cbb56c5",
                "https://drive.pegalite.com/api/shared/1f2924e9-9a2f-469f-840a-dcb66f2496bf",
                "https://drive.pegalite.com/api/shared/b2efec02-e595-4e62-84b2-bf53a40d13a4",
                "https://drive.pegalite.com/api/shared/8a4de34f-fac7-4c0c-b3c5-daa5676596b2",
                "https://drive.pegalite.com/api/shared/44028fd2-c5cb-45d9-8fae-56ccb14acc40",
                "https://drive.pegalite.com/api/shared/1a12ede7-aafb-4714-b513-9bdaa3fbd15a",
                "https://drive.pegalite.com/api/shared/7177aef4-71d4-486c-ac84-63a0c31c30bc",
                "https://drive.pegalite.com/api/shared/9f568a9c-2ea2-44a9-82a9-8735e4f2bf82",
                "https://drive.pegalite.com/api/shared/09c828d3-5f68-412c-a8e3-0a024e1488ef",
                "https://drive.pegalite.com/api/shared/e8fbac7b-70c0-4cfd-aa36-fb398e074962",
                "https://drive.pegalite.com/api/shared/e9f07bdb-13eb-42d2-9c19-87005352f8ea",
                "https://drive.pegalite.com/api/shared/b56c058a-b627-478a-9334-1413342f2d51",
                "https://drive.pegalite.com/api/shared/d16038ae-4988-4095-9df3-6fb02627be28",
                "https://drive.pegalite.com/api/shared/678c0fe1-8a9c-4807-8960-7cf0146a7ac9",
                "https://drive.pegalite.com/api/shared/2afb678a-7c23-476d-b921-2ecc0026eb5e",
                "https://drive.pegalite.com/api/shared/92e1fbba-f9df-4557-bfd1-41fea02756ae",
                "https://drive.pegalite.com/api/shared/bfab5c6f-2d7c-41bd-ae9e-090f4c19093d",
                "https://drive.pegalite.com/api/shared/9fd89056-c531-49ef-aafc-cb82ed1f7b81",
                "https://drive.pegalite.com/api/shared/23483255-475f-463e-9765-a63448ec3a87",
                "https://drive.pegalite.com/api/shared/4e0a6168-0694-42e5-bcf9-002a91212590"

        );

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        staggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);

        binding.recyclerView.setLayoutManager(staggeredGridLayoutManager);
        binding.recyclerView.setHasFixedSize(true);
//        binding.recyclerView.setItemViewCacheSize(20); // Cache more views

        ImageAdapter adapter = new ImageAdapter(this, imageUrls);
        adapter.setHasStableIds(true);
        binding.recyclerView.setAdapter(adapter);

    }

    private void setStatusBar() {
        Window window = getWindow();
        Drawable background = ContextCompat.getDrawable(this, R.drawable.top_background);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
        window.setBackgroundDrawable(background);
        setSupportActionBar(binding.toolBar);
    }
}